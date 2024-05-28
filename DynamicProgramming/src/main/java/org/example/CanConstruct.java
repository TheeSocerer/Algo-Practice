package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class CanConstruct {

    public CanConstruct() {


    }

    /**
     *
     * O(n^m*m)time
     * O(m^2)
     */

    public boolean doCanConstruct(String target, String[] words) {
        if (target.isEmpty()) {
            return true;
        }

        for (String word : words) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                if (doCanConstruct(suffix, words)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * O(n*m^2)time
     * O(m^2)
     */
    public boolean doCanConstructMemo(String target, String[] words, Hashtable<String,Boolean> memo) {
        if(memo.containsKey(target)){
            return memo.get(target);
        }
        if (target.isEmpty()) {
            return true;
        }

        for (String word : words) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                if (doCanConstructMemo(suffix, words,memo)) {
                    memo.put(target,true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;
    }

    // Brute Force
    public int doCountConstruct(String target, String[] words){
        if(target.isEmpty()){
            return 1;
        }
        int count = 0;
        for (String word : words) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                count += doCountConstruct(suffix, words);
            }
        }
        return count;
    }
    //Memo

    public int doCountConstructMemo(String target, String[] words, Hashtable<String,Integer> memo){
        if(memo.containsKey(target)){
            return memo.get(target);
        }
        if(target.isEmpty()){
            return 1;
        }

        int count = 0;
        for (String word : words) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                int numOfWays = doCountConstructMemo(suffix, words, memo);
                memo.put(target,numOfWays);
                count += numOfWays;
            }
        }
        return count;
    }
    public List<List<String>> doAllConstructMemo(String target, String[] words){

        if(target.isEmpty()){
            return new ArrayList<>(List.of(new ArrayList<>()));
        }
        List<List<String>> result = new ArrayList<>();
        for (String word : words) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                System.out.println(suffix);
                List<List<String>> suffixWays = doAllConstructMemo(suffix, words);

                addPrefix(suffixWays,word);
                System.out.println(suffixWays);

                result.addAll(suffixWays);


            }
        }
        return result;
    }
    private void addPrefix(List<List<String>> suffixWays, String word) {
        for (List<String> innerList : suffixWays) {
            innerList.add(0, word); // Add the word as the first element
        }
    }
}