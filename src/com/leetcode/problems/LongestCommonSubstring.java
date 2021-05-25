package com.leetcode.problems;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String str1 = "EducativeIsFun";
        String str2 = "AlgorithmsAreFun";
        int largestLength = (str1.length() < str2.length())
            ? longestCommonSubstring(str1, str2)
            : longestCommonSubstring(str2, str1);
        System.out.println(largestLength);
    }

    public static int longestCommonSubstring(String str1, String str2) {
        int endIndex;
        int largestLength = 0;

        for (int i = 0; i < str1.length(); i++) {
            endIndex = str1.length();
            while (endIndex > i) {
                int currentLength = str1.substring(i, endIndex).length();
                if (str2.contains(str1.substring(i, endIndex)) && currentLength > largestLength) {
                    System.out.println(str1.substring(i, endIndex));
                    largestLength = currentLength;
                    break;
                }
                endIndex--;
            }
        }

        return largestLength;
    }

    public static int longestCommonSubstringWithTable(String s1, String s2) {
        // Lookup table to store already computed subproblem solutions
        int[][] lookupTable = new int[s1.length() + 1][];

        // Initialize all values in lookupTable to zero
        for (int i = 0; i <= s1.length(); i++) {
            lookupTable[i] = new int[s2.length() + 1];
        }

        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s1.length() + 1; j++) {
                lookupTable[i][j] = 0;
            }
        }

        int maxLength = 0;

        // Filling lookupTable in a bottom up manner
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s1.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lookupTable[i][j] = 1 + lookupTable[i - 1][j - 1];
                    maxLength = Math.max(maxLength, lookupTable[i][j]);
                }
            }
        }

        return maxLength;
    }
}
