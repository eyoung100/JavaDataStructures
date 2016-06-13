package com.carterswebs.treet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ecyoung on 6/7/2016.
 * Holds and manipulates the Treet
 * class
 */
public class Treet implements Comparable<Treet>, Serializable{

    private static final long serialVersionUID = 1847014783837301605L;
    private String mAuthor;
    private String mDescription;
    private Date mCreationDate;

    /**
     * Constructor
     */
    public Treet(String author, String description, Date creationDate) {

        mAuthor = author;
        mDescription = description;
        mCreationDate = creationDate;
    }

    /**
     *
     * Public Methods
     */
    public String getAuthor() {
        return mAuthor;
    }

    public String getDescription() {
        return mDescription;
    }

    public Date getCreationDate() {
        return mCreationDate;
    }

    public List<String> getWords() {
        String[] words = mDescription.toLowerCase().split("[^\\w#@']+");
        return Arrays.asList(words);
    }

    public List<String> getHashtags() {
        return getWordsPrefixedWith("#");
    }

    public List<String> getMentions() {
        return getWordsPrefixedWith("@");
    }

    @Override
    public String toString() {
        return String.format("Treet: \"%s\" by  %s on %s", mDescription, mAuthor, mCreationDate);
    }

    @Override
    public int compareTo(Treet other) {
        if (equals(other)) {
            return 0;
        }
        int dateComparison = mCreationDate.compareTo(other.mCreationDate);
        if (dateComparison == 0) {
            return mDescription.compareTo(other.mDescription);
        }
        return dateComparison;
    }

    /**
     * Private Methods
     */

    private List<String> getWordsPrefixedWith(String prefix) {
        List<String> results = new ArrayList<String>();
        for (String word : getWords()) {
            if (word.startsWith(prefix)) {
                results.add(word);
            }
        }
        return results;
    }
}
