package org.deanlee.course.algorithm.sort;

import java.util.Arrays;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: ShellSortDemo
 * @Description: 希尔排序
 * @date 2020/8/30 21:36
 */
public class ShellSortDemo {
    public static void main(String[] args) {
        int[] sortArr = new int[]{3, 5, 1, 5, 6, 1, 20, 25};
        ShellSort(sortArr);
    }

    public static void ShellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }

        for (int i : array) {
            System.out.print(i + ", ");
        }
    }
}
