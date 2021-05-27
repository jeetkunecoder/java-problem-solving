package com.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public static void main(String[] args) {
        String[] emails = {
            "test.email+alex@leetcode.com",
            "test.e.mail+bob.cathy@leetcode.com",
            "testemail+david@lee.tcode.com"
        };
        System.out.println(getUniqueEmailAddresses(emails));
    }

    public static int getUniqueEmailAddresses(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            String processedEmail = cleanEmail(email);
            uniqueEmails.add(processedEmail);
        }
        return uniqueEmails.size();
    }

    public static String cleanEmail(String email) {
        String[] names = email.split("@");
        int endOfStr = (names[0].contains("+")) ? names[0].indexOf("+") : names[0].length();
        String localName = names[0]
            .substring(0, endOfStr)
            .replace(".", "");
        String domainName = names[1];
        return localName + "@" + domainName;
    }
}
