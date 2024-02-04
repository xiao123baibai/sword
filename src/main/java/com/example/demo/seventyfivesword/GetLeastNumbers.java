package com.example.demo.seventyfivesword;

import java.util.Arrays;

/**
 * 最小的k个数
 */
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        arr = sort(arr,0,arr.length-1);
//        Arrays.sort(arr);
        int[] ans = new int[k];
        for(int i = 0; i < arr.length; i++){
            ans[i] = arr[i];
        }
        return ans;
    }
    //快排

    public int[] sort(int[] arr,int left, int right){
        int low = left;
        int high = right;
        if (low >= high){
            return arr;
        }
        int piovt = arr[low];
        while (low < high){
            while (low < high && piovt <= arr[high]){
                high--;
            }
            arr[low] = arr[high];
            while (low < high && piovt >= arr[low]){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = piovt;
        sort(arr,left,low-1);
        sort(arr,low+1,right);
        return arr;
    }
}
