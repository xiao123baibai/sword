//package com.example.demo.fib;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 功能描述:
// *
// * @Author: qinlida
// * @Date: 2022/11/24
// */
//public class FrogJump {
//    /**
//     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//     *
//     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//     * @param n
//     * @return
//     */
//
//    public static int numWays(int n){
//        if (n < 2){
//            return 1;
//        }
//        int a = 1,b = 1,sum = 2;
//        for (int i = 2;i <= n; i++){
//            sum = (a+b)%1000000007;
//            a = b;
//            b = sum;
//        }
//        return sum;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(numWays(3));
//        String arr = "['测试',null]";
//        String arr1 = "null";
////        List<String> list = JSONArray.parseArray(arr,String.class);
//        for (String str : list){
//            System.out.println(str);
//        }
//        System.out.println("end");
//    }
//}
