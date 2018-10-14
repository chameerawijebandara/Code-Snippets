/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import Util.Util;

/**
 *
 * @author Chameera
 */
public class InsertionSort {

    public static int[] sort(int[] in) {

        for (int i = 1; i < in.length; i++) {
            int key = in[i];
            int j = i - 1;

            while (j >= 0 && in[j] > key) {
                in[j + 1] = in[j];
                --j;
            }
            in[j + 1] = key;
        }
        return in;
    }

    public static void main(String[] args) {
        int in[] = {31, 41, 59, 26, 41, 58};

        Util.printArray(in);
        int out[] = InsertionSort.sort(in);
        Util.printArray(out);
        

    }
}
