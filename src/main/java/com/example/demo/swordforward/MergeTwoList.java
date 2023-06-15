package com.example.demo.swordforward;

import javax.swing.text.AbstractDocument;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MergeTwoList {
    //将链表遍历转成list进行合并处理
    public static void main(String[] args) {

        List<Integer> tl1 = new ArrayList();
        tl1.add(1);
        tl1.add(2);
        tl1.add(3);
        tl1.add(4);
        tl1.add(5);

        List<Integer> tl2 = new ArrayList();
        tl2.add(6);
        tl2.add(7);
        tl2.add(8);
        tl2.add(0);

        List<Integer> tl3 = new ArrayList();
        tl3.add(3);
        tl3.add(4);
        tl3.add(5);

        List<Integer> tl4 = new ArrayList();
        tl4.add(2);
        tl4.add(3);
        tl4.add(4);
        tl4.add(5);
        tl4.add(6);


        merge(tl1,tl2);//链表不会合并
        merge(tl1,tl3);//链表可以合并，合并位置元素 为3
        merge(tl1,tl4);//链表可以合并，合并位置元素 为2
        merge(tl3,tl4);//链表可以合并，合并位置元素 为3

        System.out.println("七天后: "+new Date(new Date().getTime()+7*24 * 60 * 60 * 1000));
    }

    public static void merge(List<Integer> tl1,List<Integer> tl2){
        List<Integer> l1 = minList(tl1,tl2);
        List<Integer> l2 = maxList(tl1,tl2);
        int r = mergeWhere(l1,l2);
        if( r > -1 ){
            System.out.println("链表可以合并，合并位置元素 为"+l2.get(r));
        }else {
            System.out.println("链表不会合并");
        }

    }

    public static int resetPosition(){
        return -1;
    }

    public static List<Integer> maxList(List<Integer> l1,List<Integer> l2){
        return l1.size() > l2.size() ? l1:l2;
    }

    public static List<Integer> minList(List<Integer> l1,List<Integer> l2){
        return l1.size() < l2.size() ? l1:l2;
    }

    public static int mergeWhere(List<Integer> l1,List<Integer> l2){
        //合并位置
        int r = -1;
        //短链表的坐标
        int p = 0;
        for (int i= 0; i < l1.size();i++){
            if (r > -1){
                if (++p >= l2.size()){
                    break;
                }
                if (l2.get(p).equals(l1.get(i))){
                    continue;
                }
                r = resetPosition();
            }
            if ((p = l2.indexOf(l1.get(i))) > -1){
                r = p;
                continue;
            }
        }
        return r;
    }

}
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Column {
    /**
     * 读取文件中列序号
     *
     * @return
     */
    int value() default 0;
}
