package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Let's backtrack");
        List<String> result = new ArrayList<>();
        if(args.length == 1){
            generateParenthesis(Integer.parseInt(args[0]),0,0,"",result);
        }else{
            generateParenthesis(3,0,0,"",result);
        }
        System.out.println("The output of the generateParanthesis is : "+ result);
    }

    public static void generateParenthesis(int num, int left, int right, String s, List<String> result) {
        if (s.length() == num*2) {
            result.add(s);
            return;}
        if (left < num) {
            generateParenthesis(num, left+1, right, s+"(", result);
        }
        if (right < left) {
            generateParenthesis(num, left, right+1, s+")", result);
        }
    }

}
