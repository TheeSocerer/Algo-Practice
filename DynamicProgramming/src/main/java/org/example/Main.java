package org.example;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main dp = new Main();
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        System.out.println("The fib of 8 is " +dp.fib(50,new Hashtable<>()));
    }

    //memoization
    public int fib(int n, Hashtable<Integer,Integer> memo){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        if(n==1 || n==2){
            return 1;
        }
        memo.put(n,fib(n-1,memo) + fib(n-2,memo));
        return memo.get(n);
    }
}