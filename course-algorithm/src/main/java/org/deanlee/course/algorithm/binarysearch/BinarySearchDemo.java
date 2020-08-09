package org.deanlee.course.algorithm.binarysearch;

import java.util.Arrays;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: BinarySearchDemo
 * @Description: 二分法查找demo
 * 二分法查找的思路如下：
 * <p>
 * （1）首先，从数组的中间元素开始搜索，如果该元素正好是目标元素，则搜索过程结束，否则执行下一步。
 * <p>
 * （2）如果目标元素大于/小于中间元素，则在数组大于/小于中间元素的那一半区域查找，然后重复步骤（1）的操作。
 * <p>
 * （3）如果某一步数组为空，则表示找不到目标元素。
 * <p>
 * 二分法查找的时间复杂度O(logn)
 * @date 2020/8/9 22:15
 */
public class BinarySearchDemo {
    public static void main(String[] args) {
        BinarySearchDemo binarySearch = new BinarySearchDemo();
        int[] array = {10, 23, 4, 3, 2, 5, 1, 2, 623, 92, 23, 23, 234, 2, 34, 234, 234, 2, 10};
        Arrays.sort(array);
        for (int n : array) {
            System.out.print(" " + n);
        }
		binarySearch.binarySearch(array, 234,0, array.length-1);
        binarySearch.binarySearch2(array, 3);

    }

    // 递归实现
    public void binarySearch(int a[], int val, int low, int high) {
        int middle = (low + high) / 2;
        if (low < high) {
            if (a[middle] == val) {
                System.out.println("找到元素下标:" + middle);
            } else if (val < a[middle]) {
                //左边找
                binarySearch(a, val, low, middle - 1);
            } else if (val > a[middle]) {
                //左边找
                binarySearch(a, val, middle + 1, high);
            } else {
                return;
            }
        }
        return;
    }

    //非递归方式
    public void binarySearch2(int a[], int val) {
        int low = 0;
        int high = a.length - 1;
        int middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            if (val < a[middle]) {
                //左边找
                high = middle - 1;
            } else if (val > a[middle]) {
                //右边找
                low = middle + 1;
            } else {
                System.out.println("找到元素下标:" + middle);
                return;
            }
        }
        return;
    }


}
