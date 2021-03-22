package com.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadingFileLines {

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
    }
}
