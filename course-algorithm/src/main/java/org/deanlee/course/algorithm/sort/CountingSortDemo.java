package org.deanlee.course.algorithm.sort;

import java.util.Arrays;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: CountingSortDemo
 * @Description: 计数排序  额外空间
 * @date 2020/9/13 22:29
 */
public class CountingSortDemo {
    public static void main(String[] args) {
        int[] sortArr = new int[]{3, 5, 1, 5, 6, 1, 20, 25};
        for (int i : CountingSort(sortArr)) {
            System.out.printf(i + " ");
        }
    }

    /**
     * 计数排序
     *
     * @param array
     * @return
     */
    public static int[] CountingSort(int[] array) {
        if (array.length == 0) return array;
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else
                i++;
        }
        return array;
    }
}
