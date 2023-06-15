package com.example.demo.doublepointer;

/**
 * 功能描述:
 *
 * @Author: qinlida
 * @Date: 2022/9/5
 */
public class sortColors {
//    给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//    我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
//
//    必须在不使用库的sort函数的情况下解决这个问题。
//
//
//
//    示例 1：
//
//    输入：nums = [2,0,2,1,1,0]
//    输出：[0,0,1,1,2,2]
//    示例 2：
//
//    输入：nums = [2,0,1]
//    输出：[0,1,2]
//
//
//    提示：
//
//    n == nums.length
//    1 <= n <= 300
//    nums[i] 为 0、1 或 2
//
//
//    进阶：
//
//    你可以不使用代码库中的排序函数来解决这道题吗？
//    你能想出一个仅使用常数空间的一趟扫描算法吗？

    public class Solution {

//        public void sortColors(int[] nums) {
//            int len = nums.length;
//            if (len < 2) {
//                return;
//            }
//            // all in [0, zero] = 0
//            // all in (zero, i) = 1
//            // all in (two, len - 1] = 2
//
//            // 为了保证初始化的时候 [0, zero] 为空，设置 zero = -1，
//            // 所以下面遍历到 0 的时候，先加，再交换
//            int zero = -1;
//
//            // 为了保证初始化的时候 (two, len - 1] 为空，设置 two = len - 1
//            // 所以下面遍历到 2 的时候，先交换，再减
//            int two = len - 1;
//            int i = 0;
//            // 当 i == two 的时候，还有一个元素还没有看，
//            // 因此，循环可以继续的条件是 i <= two
//            while (i <= two) {
//                if (nums[i] == 0) {
//                    zero++;
//                    swap(nums, i, zero);
//                    i++;
//                } else if (nums[i] == 1) {
//                    i++;
//                } else {
//                    swap(nums, i, two);
//                    two--;
//                }
//            }
//        }
//
//        private void swap(int[] nums, int index1, int index2) {
//            int temp = nums[index1];
//            nums[index1] = nums[index2];
//            nums[index2] = temp;
//        }
            public void sortColors(int[] nums){
                int len = nums.length;
                if (len < 2){
                    return;
                }
                int zero = -1;
                int two = len - 1;
                int i = 0;
                while (i <= two){
                    if (nums[i] == 0){
                        zero++;
                        swap(nums,i,zero);
                    }else if (nums[i] == 1){
                        i++;
                    }else {
                        swap(nums,i,two);
                        two--;
                    }
                }
            }
            public void swap(int[] nums,int index1,int index2){
                int temp = nums[index1];
                nums[index1] = nums[index2];
                nums[index2] = temp;
            }
    }
}
