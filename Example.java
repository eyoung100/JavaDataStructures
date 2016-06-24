package com.carterswebs.treet;

import java.util.*;

/**
 * Created by ecyoung on 6/8/2016.
 * Example to show mechanics of
 * Data Structures in Java.
 */

 public class Example {
    public static void main(String[] args) {
        Treet[] treets = Treets.load();
        System.out.printf("There are %d treets. %n", treets.length);
        Set<String> allHashtags = new HashSet<>();
        Set<String> allMentions = new TreeSet<>();
        for (Treet treet : treets) {
            allHashtags.addAll(treet.getHashtags());
            allMentions.addAll(treet.getMentions());
        }
        System.out.printf("Hashtags: %s %n", allHashtags);
        System.out.printf("Mentions: %s %n", allMentions);

        Map<String, Integer> hashTagCounts = new HashMap<>();
        for (Treet treet : treets) {
            for (String hashTag : treet.getHashtags()) {
                Integer count = hashTagCounts.get(hashTag);
                if (count == null) {
                    count = 0;
                }
                count++;
                hashTagCounts.put(hashTag, count);

            }
        }
        System.out.printf("Hashtag Counts: %s %n", hashTagCounts);


        Map<String, List<Treet>> treetsByAuthor = new HashMap<>();
        for (Treet treet : treets) {
            List<Treet> authoredTreets = treetsByAuthor.get(treet.getAuthor());
            if (authoredTreets == null) {
                authoredTreets = new ArrayList<>();
                treetsByAuthor.put(treet.getAuthor(), authoredTreets);
            }
            authoredTreets.add(treet);
        }
        System.out.printf("Treets by Author: %s %n", treetsByAuthor);
    }
}
