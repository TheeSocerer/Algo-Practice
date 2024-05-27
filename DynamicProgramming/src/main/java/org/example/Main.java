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
//        System.out.println("Hello world!");
//        Main dp = new Main();
//        Hashtable<String, Integer> gridTraveller = new Hashtable<>();
//        System.out.println("This is the Fibonnaci");
//        System.out.println("The fib of 8 is " +dp.fib(50,new Hashtable<>()));
//
//        System.out.println("This is the Grid Traveller");
//        System.out.println("You can travel using this many paths " +dp.gridTraveller(16,16,gridTraveller));
//
//        System.out.println("This is the CANSUM combination");
//        Hashtable<Integer, Boolean> canSum = new Hashtable<>();
//        System.out.println(dp.canSum(9,new int[]{2,4,2,6}, canSum));
//        System.out.println(dp.canSum(11,new int[]{5,4,2,3},new Hashtable<>()) );
//        System.out.println(dp.canSum(10102,new int[]{3,4,2,1}, new Hashtable<>()) );
//        System.out.println(dp.canSum(1,new int[]{2,4,2,3}, new Hashtable<>()) );
//
//        System.out.println("This is the HOWSUM combination");
//        System.out.println(dp.howSum(9,new int[]{2,4,2,6},new Hashtable<>()));
//        System.out.println(dp.howSum(11,new int[]{5,4,2,3},new Hashtable<>()) );
//        System.out.println(dp.howSum(10,new int[]{3,4,2,1},new Hashtable<>()) );
//        System.out.println(dp.howSum(1,new int[]{2,4,2,3},new Hashtable<>()) );
//
//        System.out.println("This is the BESTSUM combination");
//        System.out.println(dp.bestSum(9,new int[]{2,4,2,6}));
//        System.out.println(dp.bestSum(11,new int[]{5,4,2,3}) );
//        System.out.println(dp.bestSum(10,new int[]{3,4,2,1}) );
//        System.out.println(dp.bestSum(1,new int[]{2,4,2,3}) );

        CanConstruct c = new CanConstruct();
        System.out.println("CanConstruct Brute Force");
        System.out.println(c.doCountConstruct("abcdef",new String[]{"ab","abc","cd","def","abcd"}));
        System.out.println(c.doCountConstruct("skateboard",new String[]{"bo","rd","ate","t","ska","sk","boar"}));
        System.out.println(c.doCanConstruct("enterapotentpot",new String[]{"a","p","ent","enter","ot","o","t"}));
        System.out.println(c.doCountConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeef",new String[]{
                "e",
                "ee",
                "eee",
                "eeee",
                "eeeee",
                "eeeeeee"}, new Hashtable<>()));
        System.out.println("CanConstruct After Memo");

        System.out.println(c.doCanConstructMemo("abcdef",new String[]{"ab","abc","cd","def","abcd"},new Hashtable<>()));
        System.out.println(c.doCanConstructMemo("skateboard",new String[]{"bo","rd","ate","t","ska","sk","boar"},new Hashtable<>()));
        System.out.println(c.doCanConstructMemo("enterapotentpot",new String[]{"a","p","ent","enter","ot","o","t"},new Hashtable<>()));
        System.out.println(c.doCanConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeef",new String[]{
                "e",
                "ee",
                "eee",
                "eeee",
                "eeeee",
                "eeeeeee"},new Hashtable<>()));
        System.out.println(c.doAllConstructMemo("purple",new String[]{"purp","p","ur","le","purpl","purpl"}));

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

    //Can you do it? yes/no
    // Decision problem
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
    /**
     * m = targetSum
     * n = array lenth
     *
     * O(n^m*m) time
     * O(m) space
     *
     * after memoization
     * O(n*m^2)
     * O(m^2)
     **/

    //how will you do it?
    //Combination problem
    public List<Integer> howSum(int targetSum, int[] numbers,Hashtable<Integer,List<Integer>> memo){
        if(memo.containsKey(targetSum)){
            return memo.get(targetSum);
        }
        if(targetSum == 0){
            return new ArrayList<>();
        }
        if(targetSum<0){
            return null;
        }

        for(int i: numbers){
            int remainder = targetSum - i;

            List<Integer> remainderResult = howSum(remainder,numbers,memo);
            if(remainderResult != null){
                remainderResult.add(i);
                memo.put(remainder,remainderResult);
                return remainderResult;
            }

        }
        return null;
    }

    /**
     * m = targetSum
     * n = array lenth
     *
     * O(n^m*m) time
     * O(m) space
     *
     * after memoization
     * O(n*m^2)
     * O(m^2)
     **/

    //What is the 'best' way to do it?
    //Optimization problem
    public List<Integer> bestSum(int targetSum, int[] numbers){
        if(targetSum==0){
            return new ArrayList<>();
        }
        if(targetSum < 0){
            return null;
        }
        List<Integer> shortestCombination = null;
        for(int i: numbers){
            int remainder = targetSum -i;
            List<Integer> remainderResult = bestSum(remainder,numbers);
            if(remainderResult != null){
                remainderResult.add(i);
                if(shortestCombination == null || remainderResult.size() < shortestCombination.size()){
                    shortestCombination = remainderResult;
                }
            }
        }
        return shortestCombination;
    }

}