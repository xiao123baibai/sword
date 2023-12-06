package com.example.demo.seventyfivesword;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 121-股票的最大利润
 */
public class MaxProfit {
    /**
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     *
     *
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * 示例 2:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */
    //思路：寻找最小节点，寻早最大节点  优先队列寻找较小节点信息，从较小节点后面寻找最大的节点--该解法不适合这个题
    public int maxProfit(int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        int res = 0;
        int max = prices[1];
        int min = prices[0];
        if (prices.length == 2 &&max<min){
            return 0;
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i < prices.length;i++){
            map.put(i,prices[i]);
        }
        queue.addAll(map.entrySet());
        while (!queue.isEmpty()){
           Map.Entry<Integer,Integer> entry = queue.poll();
           //处理每个位置的最大值
            int tempMax = 0;
            for (int i = entry.getKey()+1;i<prices.length;i++){
                tempMax = Math.max(tempMax,prices[i]);
            }
            if (tempMax > entry.getValue()){
                res = Math.max(res,tempMax- entry.getValue());
            }
        }
        return res;
    }
    //思路二：
    public int maxProfit1(int[] prices){
        int ans = 0;
        int cost = 0;
        for (int i = 0; i < prices.length; i++){
            int price = prices[i];
            cost = Math.min(cost,price);
            ans = Math.max(ans,price-cost);
        }
        return ans;
    }
}
