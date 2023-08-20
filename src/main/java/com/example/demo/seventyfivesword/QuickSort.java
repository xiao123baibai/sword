package com.example.demo.seventyfivesword;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public int[] sort(int[] arr,int left, int right){
        int low = left;
        int high = right;
        if (low >= high){
            return arr;
        }
        int piovt = arr[low];//将第一个数定位基准
        while (low < high){
            while (low < high && piovt <= arr[high]){//右边的数组比基准数大
                high--;
            }
            arr[low] = arr[high];//右边小于基准数的元素与左边位置的交互
            while (low < high && piovt >= arr[low]){//左边的数据比急哦准数小
                low++;
            }
            arr[high] = arr[low];////左边小于基准数的元素与右边位置的交互
        }
        //开始递归
        arr[low] = piovt;//交换数实质商有个基准数位置的空缺，那么在循环结束的时候，从新将基准数放在他应该在的位置arr[low]
        sort(arr,left,low-1);
        sort(arr,low+1,right);
        return arr;
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] arr = new int[]{6,2,3,1,5};
        q.sort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
