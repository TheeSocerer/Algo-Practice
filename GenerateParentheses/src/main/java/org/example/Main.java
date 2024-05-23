package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("Let's backtrack");
        List<String> result;
        if(args.length == 1){
            result = m.generate(Integer.parseInt(args[0]));
        }else{
            result = m.generate(3);
        }
        System.out.println("The output of the generateParanthesis is : "+ result);
    }

    public void generateParenthesis(int num, int left, int right, String s, List<String> result) {
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

    public List<String> generate(int n){
        List<String> result = new ArrayList<>();
        generateParenthesis(n,0,0,"",result);
        return result;
    }

}
