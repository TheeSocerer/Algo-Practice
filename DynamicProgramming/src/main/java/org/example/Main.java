package org.example;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main dp = new Main();
        Hashtable<String, Integer> gridTraveller = new Hashtable<>();
//        System.out.println("The fib of 8 is " +dp.fib(50,new Hashtable<>()));
        System.out.println("You can travel using this many paths " +dp.gridTraveller(16,16,gridTraveller));
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

    public int gridTraveller(int m, int n,Hashtable<String, Integer> memo){
        String key = m + "," + n;
        String key2 = n + "," +m;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(m== 1 || n==1){
            return 1;
        }
        if(m==0 || n==0){
            return 0;
        }
        memo.put(key,gridTraveller(m-1,n, memo) + gridTraveller(m,n-1,memo));
        memo.put(key2,memo.get(key));
        return memo.get(key);
    }
}