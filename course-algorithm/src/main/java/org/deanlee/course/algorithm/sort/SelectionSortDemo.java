package org.deanlee.course.algorithm.sort;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: SelctionSortDemo
 * @Description: 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 * @date 2020/8/23 21:26
 * 算法描述
 * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
 * 1.初始状态：无序区为R[1..n]，有序区为空；
 * 2.第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
 * 3.n-1趟结束，数组有序化了。
 * <p>
 * 平均时间复杂度  最好时间复杂度 最差时间复杂度 空间复杂度   稳定性
 * * O(n^2)           O(n^2)         O(n^2)      O(1)    不稳定
 */
public class SelectionSortDemo {
    public static void main(String[] args) {
        int[] sortArr=new int[]{3,5, 1, 5, 6, 1, 20, 25};
        selectSort(sortArr,sortArr.length);
        for (int i : sortArr) {
            System.out.printf(i+",");
        }

    }

    public static void selectSort(int array[], int lenth) {

        for (int i = 0; i < lenth - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < lenth; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

}
