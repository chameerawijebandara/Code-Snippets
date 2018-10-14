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
public class MergeSort {

    public static void sort(int in[]) {
        mergeSort(in, 0, in.length);
    }

    public static void mergeSort(int in[], int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(in, p, q);
            mergeSort(in, q + 1, r);
            merge(in, p, q, r);
        }
    }

    private static void merge(int in[], int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = in[p + i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = in[q + i + 1];
        }

        int i = 0;
        int j = 0;

        for (int k = p; k < r; k++) {
            if (j == n2 || L[i] < R[j]) {
                in[k] = L[i++];
            } else {
                in[k] = R[j++];
            }
        }
    }

    public static void main(String[] args) {
        int in[] = {3, 41, 52, 26, 38, 57, 9, 49};

        Util.printArray(in);
        InsertionSort.sort(in);
        Util.printArray(in);

    }
}
