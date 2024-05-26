package org.example;

public class CanConstruct {

    public CanConstruct() {


    }

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
}