package com.utils;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadingFileLines {

    private static final int MAP_SIZE = 5242880; // 5MB Repr.

    public static void main(String[] args) throws IOException {


        /**
         * Technique 1: Use streams of data
         *
         * Pros:
         * - Good usage of the memory as we request the data
         *   only when we need it, this way we avoid exhausting
         *   the memory resources in the heap.
         *
         * Cons:
         * - Larger and more unreadable code
         */

        FileInputStream inputStream = null;
        Scanner sc = null;

        try {
            inputStream = new FileInputStream("path/to/file");
            sc = new Scanner(inputStream, StandardCharsets.UTF_8);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }

            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) inputStream.close();
            if (sc != null) sc.close();
        }

        /**
         * Technique 2:
         * - Load the whole file into memory using NIO
         *
         * Pros:
         * - Easy and fast solution
         *
         * Cons:
         * - With a sufficiently large file, we end up
         *   with OOM errors by exhausting the Java heap space;
         */

        String str = Files.readString(Paths.get("path/to/file"));

        /**
         * Technique 3:
         * - Loading a binary file in chunks
         *
         * Pros:
         * - Better usage of memory than with NIO
         *
         * Cons:
         * - The code can be a bit confusing
         * - As we read the data chunk by chunk,
         *   it may be difficult to manipule
         */

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("path"))) {
            byte[] bbuf = new byte[4096];
            int len;
            while ((len = in.read(bbuf)) != -1) {
                System.out.println("Byte content: " + len);
            }
        }

        /**
         * Technique 4:
         * - Reading a text file line by line with BufferedReader
         */

        try (BufferedReader in = new BufferedReader(new FileReader("path"))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Line content: " + line);
            }
        }

        /**
         * Technique 5: Using Java Streams
         */

        List<String> list = Files.lines(Paths.get("path/to/file"))
            .filter(line -> line.contains("abc"))
            .collect(Collectors.toList());

        /**
         * Technique 6: Using FileReader with Charsets
         */

        Path chineseFile = Paths.get("chinese.txt");
        try (FileReader fr = new FileReader(chineseFile.toFile(), StandardCharsets.UTF_16)) {
            int i;
            while((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
        }

        /**
         * Technique 7: Using BufferedReader
         */

        try (BufferedReader br = Files.newBufferedReader(chineseFile, StandardCharsets.UTF_16)) {
            String line ;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        /**
         * Technique 8:
         *
         * - Combining BufferedReader with InputStreamReader
         */

        FileInputStream fis = new FileInputStream(chineseFile.toFile());
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_16);
        try (BufferedReader br = new BufferedReader(isr)) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        /**
         * Technique 9: Using MappedByteBuffer to handle large files
         * - Creates and modifies huge files while treating them
         *   as very big arrays.
         * - They look like they are in memory, even if they're not.
         *   Everything happens at the native level.
         */

        try (FileChannel fileChannel = (
                FileChannel.open(chineseFile, EnumSet.of(StandardOpenOption.READ)))) {

            MappedByteBuffer mbBuffer = fileChannel
                .map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

            if (mbBuffer != null) {
                String bufferContent = StandardCharsets.UTF_16.decode(mbBuffer).toString();
                System.out.println(bufferContent);
                mbBuffer.clear();
            }
        }

        /**
         * Technique 10: Fixed size buffer with MappedByteBuffer
         * - Handles very large files
         */

        try (FileChannel fileChannel = (FileChannel.open(chineseFile, EnumSet.of(StandardOpenOption.READ)))) {
            int position = 0;
            long length = fileChannel.size();

            while (position < length) {
                long remaining = length - position;
                int bytesToMap = (int) Math.min(MAP_SIZE, remaining);

                MappedByteBuffer mbBuffer = fileChannel
                    .map(FileChannel.MapMode.READ_ONLY, position, bytesToMap);

                // Here we do something with the current buffer

                position += bytesToMap;
            }
        }
    }
}
