package com.example.demo.onehundredandfifty;

import java.util.*;

/**
 * 121. 买卖股票的最佳时机
 */
public class MaxProfit {
    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2：
     *
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     *
     * 提示：
     *
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 104
     */
    //思路：寻找最小值  同时循环的每个值都去和最小值做差
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1;i < prices.length;i++){
            if (prices[i] > min){
                maxProfit = Math.max(maxProfit,prices[i]-min);
            }
            min = Math.min(min,prices[i]);
        }
        return maxProfit;
    }

//    public static void main(String[] args) {
//        int[] nums = new int[]{7,1,5,3,6,4};
//        maxProfit(nums);
//    }

    public int maxProfit1(int[] prices){
        int profit = 0;
        int min = prices[0];
        for (int i = 1;i<prices.length;i++){
            profit = Math.max(profit,prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        int a = 0, b = 0, c = 0, d = 0, e = 0, error = 0, p = 0;
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            String[] sArr = s.split("~");
            if(isA(sArr[0]) && isA(sArr[1])){
                a++;
            }else if(isB(sArr[0]) && isB(sArr[1])){
                b++;
            }else if(isC(sArr[0]) && isC(sArr[1])){
                c++;
            }else if(isD(sArr[0]) && isD(sArr[1])){
                d++;
            }else if(isE(sArr[0]) && isE(sArr[1])){
                e++;
            }else if(isIgnore(sArr[0]) || isIgnore(sArr[1])){
                continue;
            }else if((isPrivateOne(sArr[0]) || isPrivateTwo(sArr[0]) || isPrivateThree(sArr[0])) &&
                    (isPrivateOne(sArr[1]) || isPrivateTwo(sArr[1]) || isPrivateThree(sArr[1]))){
                p++;
            }else{
                error++;
            }
        }
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + error + " " + p);
    }
    private static boolean isA(String str) {
        Integer[] A1 = new Integer[] {1, 0, 0, 0};
        Integer[] A2 = new Integer[] {126, 255, 255, 255};
        String[] arr = str.split("\\.");
        if (arr.length < 4){
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i].equals("") || Integer.valueOf(arr[i]) < A1[i] || Integer.valueOf(arr[i]) > A2[i]) {
                return false;
            }
        }
        return true;
    }
    private static boolean isB(String str) {
        Integer[] B1 = new Integer[] {128, 0, 0, 0};
        Integer[] B2 = new Integer[] {191, 255, 255, 255};
        String[] arr = str.split("\\.");
        if (arr.length < 4){
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i].equals("") || Integer.valueOf(arr[i]) < B1[i] || Integer.valueOf(arr[i]) > B2[i]) {
                return false;
            }
        }
        return true;
    }
    private static boolean isC(String str) {
        Integer[] C1 = new Integer[] {192, 0, 0, 0};
        Integer[] C2 = new Integer[] {223, 255, 255, 255};
        String[] arr = str.split("\\.");
        if (arr.length < 4){
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i].equals("") || Integer.valueOf(arr[i]) < C1[i] || Integer.valueOf(arr[i]) > C2[i]) {
                return false;
            }
        }
        return true;
    }
    private static boolean isD(String str) {
        Integer[] D1 = new Integer[] {224, 0, 0, 0};
        Integer[] D2 = new Integer[] {239, 255, 255, 255};
        String[] arr = str.split("\\.");
        if (arr.length < 4){
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i].equals("") || Integer.valueOf(arr[i]) < D1[i] || Integer.valueOf(arr[i]) > D2[i]) {
                return false;
            }
        }
        return true;
    }
    private static boolean isE(String str) {
        Integer[] E1 = new Integer[] {240, 0, 0, 0};
        Integer[] E2 = new Integer[] {255, 255, 255, 255};
        String[] arr = str.split("\\.");
        if (arr.length < 4){
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i].equals("") || Integer.valueOf(arr[i]) < E1[i] || Integer.valueOf(arr[i]) > E2[i]) {
                return false;
            }
        }
        return true;
    }
    private static boolean isPrivateOne(String str) {
        Integer[] one1 = new Integer[] {10, 0, 0, 0};
        Integer[] one2 = new Integer[] {10, 255, 255, 255};
        String[] arr = str.split("\\.");
        if (arr.length < 4){
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i].equals("") || Integer.valueOf(arr[i]) < one1[i] || Integer.valueOf(arr[i]) > one2[i]) {
                return false;
            }
        }
        return true;
    }
    private static boolean isPrivateTwo(String str) {
        Integer[] two1 = new Integer[] {172, 16, 0, 0};
        Integer[] two2 = new Integer[] {172, 31, 255, 255};
        String[] arr = str.split("\\.");
        if (arr.length < 4){
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i].equals("") || Integer.valueOf(arr[i]) < two1[i] || Integer.valueOf(arr[i]) > two2[i]) {
                return false;
            }
        }
        return true;
    }
    private static boolean isPrivateThree(String str) {
        Integer[] three1 = new Integer[] {192, 168, 0, 0};
        Integer[] three2 = new Integer[] {192, 168, 255, 255};
        String[] arr = str.split("\\.");
        if (arr.length < 4){
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i].equals("") || Integer.valueOf(arr[i]) < three1[i] || Integer.valueOf(arr[i]) > three2[i]) {
                return false;
            }
        }
        return true;
    }
    private static boolean isIgnore(String str){
        String[] arr = str.split("\\.");
        if(Integer.valueOf(arr[0]) == 0 || Integer.valueOf(arr[0]) == 127){
            return true;
        }
        return false;
    }
}
