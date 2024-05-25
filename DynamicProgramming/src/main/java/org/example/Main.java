package org.example;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main dp = new Main();
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
//        System.out.println("The fib of 8 is " +dp.fib(50,new Hashtable<>()));
        System.out.println("You can travel using this many paths " +dp.gridTraveller(3,3));
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

    public int gridTraveller(int m, int n){

        if(m== 1 || n==1){
            return 1;
        }
        if(m==0 || n==0){
            return 0;
        }
        return gridTraveller(m-1,n) + gridTraveller(m,n-1);
    }
}