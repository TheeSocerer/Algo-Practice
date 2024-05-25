package org.example;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
//O(n^m) time
//O(m) space

//after memoization
//O(n*m)
//O(m)
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main dp = new Main();
        Hashtable<String, Integer> gridTraveller = new Hashtable<>();
//        System.out.println("The fib of 8 is " +dp.fib(50,new Hashtable<>()));
//        System.out.println("You can travel using this many paths " +dp.gridTraveller(16,16,gridTraveller));

//        Hashtable<Integer, Boolean> canSum = new Hashtable<>();
//        System.out.println(dp.canSum(9,new int[]{2,4,2,6}, canSum));
//        System.out.println(dp.canSum(11,new int[]{5,4,2,3},new Hashtable<>()) );
//        System.out.println(dp.canSum(10102,new int[]{3,4,2,1}, new Hashtable<>()) );
//        System.out.println(dp.canSum(1,new int[]{2,4,2,3}, new Hashtable<>()) );


        System.out.println(dp.howSum(9,new int[]{2,4,2,6}));
        System.out.println(dp.howSum(11,new int[]{5,4,2,3}) );
        System.out.println(dp.howSum(10,new int[]{3,4,2,1}) );
        System.out.println(dp.howSum(1,new int[]{2,4,2,3}) );

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

    public boolean canSum(int targetSum, int[] numbers, Hashtable<Integer, Boolean> memo){
        if(memo.containsKey(targetSum)){
            return memo.get(targetSum);
        }
        if(targetSum == 0){
            return true;
        }
        if(targetSum<0){
            return false;
        }

        for(int i: numbers){
            int remainder = targetSum - i;
            if (canSum(remainder,numbers, memo)){
                memo.put(targetSum,true);
                return true;
            }
        }
        memo.put(targetSum, true);
        return false;
    }

    public List<Integer> howSum(int targetSum, int[] numbers){
        if(targetSum == 0){
            return new ArrayList<>();
        }
        if(targetSum<0){
            return null;
        }

        for(int i: numbers){
            int remainder = targetSum - i;

            List<Integer> remainderResult = howSum(remainder,numbers);
            if(remainderResult != null){
                remainderResult.add(i);
                return remainderResult;
            }

        }
        return null;
    }
}