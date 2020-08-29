package org.deanlee.course.algorithm.sort;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: BubbleSort
 * @Description: 插入排序 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，
 * 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 */
public class InsertionSortDemo {
    public static void main(String[] args) {
        int[] sortArr = new int[]{3, 5, 1, 5, 6, 1, 20, 25};
        InsertionSort(sortArr);
    }

    private static void InsertionSort(int[] arr) {
        for (int i : arr) {
            System.out.printf(i  + " ");
        }

        int preIndex, current;
        for (int i = 1; i < arr.length; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }

        for (int i : arr) {
            System.out.printf(i + " ");
        }

    }

}
