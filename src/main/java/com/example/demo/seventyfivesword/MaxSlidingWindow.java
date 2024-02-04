package com.example.demo.seventyfivesword;


import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 滑动窗口的最大值
 */
public class MaxSlidingWindow {
    /**
     * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     *
     * 示例:
     *
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     *
     *   滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     */
    //遍历法：
    //1、找出第一个窗口最新大的值
    //2、滑动窗口，对比每次的  deletedHead push max
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        //单调队列
        //下面是要注意的点：
        //队列按从大到小放入
        //如果首位值（即最大值）不在窗口区间，删除首位
        //如果新增的值小于队列尾部值，加到队列尾部
        //如果新增值大于队列尾部值，删除队列中比新增值小的值，如果在把新增值加入到队列中
        //如果新增值大于队列中所有值，删除所有，然后把新增值放到队列首位，保证队列一直是从大到小
        if (nums.length == 0)   return nums;

        Deque<Integer> deque = new LinkedList<>();
        int[] arr = new int[nums.length - k + 1];
        int index = 0;  //arr数组的下标
        //未形成窗口区间
        for (int i = 0; i < k; i++) {
            //队列不为空时，当前值与队列尾部值比较，如果大于，删除队列尾部值
            //一直循环删除到队列中的值都大于当前值，或者删到队列为空
            while (!deque.isEmpty() && nums[i] > deque.peekLast())  deque.removeLast();
            //执行完上面的循环后，队列中要么为空，要么值都比当前值大，然后就把当前值添加到队列中
            deque.addLast(nums[i]);
        }
        //窗口区间刚形成后，把队列首位值添加到队列中
        //因为窗口形成后，就需要把队列首位添加到数组中，而下面的循环是直接跳过这一步的，所以需要我们直接添加
        arr[index++] = deque.peekFirst();
        //窗口区间形成
        for (int i = k; i < nums.length; i++) {
            //i-k是已经在区间外了，如果首位等于nums[i-k]，那么说明此时首位值已经不再区间内了，需要删除
            if (deque.peekFirst() == nums[i - k])   deque.removeFirst();
            //删除队列中比当前值大的值
            while (!deque.isEmpty() && nums[i] > deque.peekLast())  deque.removeLast();
            //把当前值添加到队列中
            deque.addLast(nums[i]);
            //把队列的首位值添加到arr数组中
            arr[index++] = deque.peekFirst();
        }
        return arr;
    }

    //单调队列
    public int[] maxSlidingWindow2(int[] nums,int k){
        if (nums.length == 0) return nums;
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        //窗口未形成的场景
        for (int i = 0;i < k; i++){
            while (deque.size() > 0 && nums[i] > deque.peekLast()){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        result[index++] = deque.peekFirst();
        //窗口已形成的场景
        for (int j = k;j < nums.length; j++){
            //窗口移动，删除前置节点
            // i-k是已经在区间外了，如果首位等于nums[i-k]，那么说明此时首位值已经不再区间内了，需要删除
            if (deque.peekFirst() == nums[j-k]){
                deque.removeFirst();
            }
            //保证数组的降序
            while (deque.size() > 0 && nums[j] > deque.peekLast()){
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            result[index++] = deque.peekFirst();
        }
        return result;
    }
    public int[] maxSlidingWindow4(int[] nums,int k){
        if (nums.length == 0){
            return nums;
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - 1 -k];
        int index = 0;
        //窗口尚未形成
        for (int i = 0; i < k; i++){
            while (deque.size() > 0 && nums[i] > deque.peekFirst()){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        result[index++] = deque.peekFirst();
        for (int j = k; j < nums.length; j++){
            if (deque.peekFirst() == nums[j-k]){
                deque.removeFirst();
            }
            while (deque.size() > 0 && nums[j] > deque.peekFirst()){
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            result[index++] = deque.peekFirst();
        }
        return result;
    }
    //优先队列---更好理解
    public int[] maxSlidingWindow3(int[] nums,int k){
        if (nums.length == 0){
            return nums;
        }
        int n = nums.length;
        int[] ans = new int[n-k+1];
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] != p2[0] ? p2[0] - p1[0] : p2[1] - p1[1];
            }
        });
        //先将前k的元素放入优先队列排序
        for (int i = 0; i < k;i++){
            pq.offer(new int[]{nums[i],i});
        }
        ans[0] = pq.peek()[0];
        //形成滑动窗口，并处理左边出界问题
        for (int i = k;i < n;i++){
            pq.offer(new int[]{nums[i],i});
            while (pq.peek()[1] <= i-k){
                pq.poll();
            }
            ans[i-k+1] = pq.peek()[0];
        }
        return ans;
    }
    public static void main(String[] args) {
        Person person = new Person();
        person.setName(new String("-1"));
        System.out.println("结果："+((person.getName()) == "-1"));
    }

    public static void aaa(Integer p) {
        p = 2;
    }
    static class Person {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

