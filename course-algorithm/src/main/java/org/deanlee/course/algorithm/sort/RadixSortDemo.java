package org.deanlee.course.algorithm.sort;

import java.util.ArrayList;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: RadixSortDemo
 * @Description: 基数排序
 * @date 2020/9/20 21:55
 */
public class RadixSortDemo {
    public static void main(String[] args) {
        int[] sortArr = new int[]{3, 5, 1, 4, 6, 30, 20, 25};
        for (Integer i:RadixSort(sortArr)){
            System.out.printf(i + " ");
        };
    }
    /**
     * 基数排序
     *
     * @param array
     * @return
     */
    public static int[] RadixSort(int[] array) {
        if (array == null || array.length < 2)
            return array;
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<Integer>());
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    array[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
        return array;
    }

}
