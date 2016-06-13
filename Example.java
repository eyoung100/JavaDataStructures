package com.carterswebs.treet;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ecyoung on 6/8/2016.
 * Example to show mechanics of
 * Data Structures in Java.
 */

 public class Example {
    public static void main(String[] args) {
        Treet[] treets = Treets.load();
        System.out.printf("There are %d treets. %n", treets.length);
        Set<String> allHashtags = new HashSet<String>();
        Set<String> allMentions = new TreeSet<String>();
        for (Treet treet : treets) {
            allHashtags.addAll(treet.getHashtags());
            allMentions.addAll(treet.getMentions());
        }
        System.out.printf("Hashtags: %s %n", allHashtags);
        System.out.printf("Mentions: %s %n", allMentions);
    }
}
