/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import static Sort.MergeSort.sort;
import Util.Util;

/**
 *
 * @author Chameera
 */
public class BubbleSort {

    public static void sort(int in[]) {
        for (int i = 0; i < in.length; i++) {
            for (int j = in.length - 1; j > i; j--) {
                if (in[j] < in[j - 1]) {
                    int temp = in[j];
                    in[j] = in[j - 1];
                    in[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int in[] = {3, 41, 52, 26, 38, 57, 9, 49};

        Util.printArray(in);
        sort(in);
        Util.printArray(in);
    }
}
