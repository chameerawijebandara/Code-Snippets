/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import static Sort.MergeSort.sort;
import Util.Util;
import java.util.Arrays;

/**
 *
 * @author Chameera
 */
public class CountingSort {

    private static void countingSort(int in[], int out[], int k) {
        int hold[] = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            hold[i] = 0;
        }

        for (int i = 0; i < in.length; i++) {
            hold[in[i]]++;
        }

        for (int i = 1; i <= k; i++) {
            hold[i] += hold[i - 1];
        }

        for (int i = 0; i < in.length; i++) {
            out[hold[in[i]] - 1] = in[i];
            hold[in[i]]--;
        }
    }

    private static void sort(int in[]) {
        int max = in[0];
        for (int i = 1; i < in.length; i++) {
            if (max < in[i]) {
                max = in[i];
            }
        }

        int out[] = new int[in.length];
        countingSort(in, out, max);

        System.arraycopy(out, 0, in, 0, in.length);
    }

    public static void main(String[] args) {
        int in[] = {5, 3, 17, 10, 84, 19, 6, 22, 9, 5, 3, 17, 10, 84, 19, 6, 22, 9};

        Util.printArray(in);
        sort(in);
        Util.printArray(in);
    }
}
