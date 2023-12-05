package com.example.demo.seventyfivesword;

import org.bouncycastle.jcajce.provider.symmetric.Serpent;

import java.awt.*;

/**
 * 扑克牌中的顺子
 */
public class IsStraight {
    /**
     * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
     * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3,4,5]
     * 输出: True
     * <p>
     * <p>
     * 示例 2:
     * <p>
     * 输入: [0,0,1,2,5]
     * 输出: True
     */
    //思路分析：首先sort一下，然后循环处理，循环处理中注意大小王的个数进行替换
    public static boolean isStraight(int[] nums) {
        boolean flag = true;
        //快速排序整理
        int[] arr = sort(nums, 0, nums.length - 1);
        //将为0的单独存储‘
        int count = 0;
        for (int i = 0; i < nums.length;i++){
            if (arr[i] == 0){
                count++;
            }
        }
        //开始循环
        int temp = arr[count];
        for (int j = count+1;j < nums.length;j++){
            temp++;
            if (temp == arr[j]){
                continue;
            }else {
                if (count>0){
                    count--;
                    j--;
                }else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private static int[] sort(int[] arr, int left, int right) {
        int head = left;
        int tail = right;
        if (left >= right) {
            return arr;
        }
        int posvite = arr[head];
        while (head < tail) {
            while (head < tail && posvite <= arr[tail]) {
                tail--;
            }
            arr[head] = arr[tail];
            while (head < tail && posvite >= arr[head]) {
                head++;
            }
            arr[tail] = arr[head];
        }
        arr[head] = posvite;
        sort(arr, left, head - 1);
        sort(arr, head + 1, right);
        return arr;
    }
    //思路2:除大小王外，所有牌 无重复 ；
    //设此 555 张牌中最大的牌为 maxmaxmax ，最小的牌为 minminmin （大小王除外），则需满足：
    //max−min<5 max - min < 5
    //max−min<5
    //

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,2,5};
        isStraight(arr);
    }
}
