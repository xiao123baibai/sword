package com.example.demo.seventyfivesword;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 */
public class MinNumber {
    /**
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     *
     *
     *
     * 示例 1:
     *
     * 输入: [10,2]
     * 输出: "102"
     * 示例 2:
     *
     * 输入: [3,30,34,5,9]
     * 输出: "3033459"
     */
    //比较器：Goods[] arr = new Goods[6];
    //        arr[0] = new Goods("lenovoMouse",34);
    //        arr[1] = new Goods("dellMouse",43);
    //        arr[2] = new Goods("xiaomiMouse",12);
    //        arr[3] = new Goods("huaweiMouse",65);
    //        arr[4] = new Goods("huaweiMouse",224);
    //        arr[5] = new Goods("microsoftMouse",43);
    //
    //        Arrays.sort(arr, new Comparator() {
    //            //指明商品比较大小的方式:按照产品名称从低到高排序,再按照价格从高到低排序
    //            @Override
    //            public int compare(Object o1, Object o2) {
    //                if(o1 instanceof Goods && o2 instanceof Goods){
    //                    Goods g1 = (Goods)o1;
    //                    Goods g2 = (Goods)o2;
    //                    if(g1.getName().equals(g2.getName())){
    //                        return -Double.compare(g1.getPrice(),g2.getPrice());
    //                    }else{
    //                        return g1.getName().compareTo(g2.getName());
    //                    }
    //                }
    //                throw new RuntimeException("输入的数据类型不一致");
    //            }
    //        });
    //————————————————
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i ++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs,(x,y)->(x+y).compareTo(y+x));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i ++){
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
