package com.example.demo.seventyfivesword;

import java.util.Arrays;

/**
 * 最小的k个数
 */
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        for(int i = 0; i < arr.length; i++){
            ans[i] = arr[i];
        }
        return ans;
    }
}
