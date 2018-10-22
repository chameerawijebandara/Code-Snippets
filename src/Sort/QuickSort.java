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
public class QuickSort {

    private static void quickSort(int in[], int p, int r) {
        if (p < r) {
            int q = partition(in, p, r);
            quickSort(in, p, q);
            quickSort(in, q + 1, r);
        }
    }

    private static int partition(int in[], int p, int r) {
        int x = in[r - 1];
        int i = p;

        for (int j = p; j < r - 1; j++) {
            if (in[j] <= x) {
                int temp = in[i];
                in[i] = in[j];
                in[j] = temp;
                i++;
            }
        }
        int temp = in[i];
        in[i] = in[r - 1];
        in[r - 1] = temp;

        return i;

    }

    private static int randomizedPartition(int in[], int p, int r) {
        int i = p + (int) (Math.random() * (r - p - 1));
        int temp = in[i];
        in[i] = in[r - 1];
        in[r - 1] = temp;

        return partition(in, p, r);
    }

    private static void randomizedQuickSort(int in[], int p, int r) {
        if (p < r) {
            int q = randomizedPartition(in, p, r);
            randomizedQuickSort(in, p, q);
            randomizedQuickSort(in, q + 1, r);
        }
    }

    public static void sort(int in[]) {
        quickSort(in, 0, in.length);
    }

    public static void randomizedSort(int in[]) {
        randomizedQuickSort(in, 0, in.length);
    }

    public static void main(String[] args) {
        int in[] = {3, 41, 52, 26, 38, 57, 9, 49};
        int in1[] = {13, 19, 9, 5, 12, 8, 7, 4, 11, 2, 6, 21};

        System.out.println("QUICKSORT");

        Util.printArray(in);
        sort(in);
        Util.printArray(in);

        System.out.println("RANDOMIZED QUICKSORT");

        Util.printArray(in1);
        randomizedSort(in1);
        Util.printArray(in1);
    }

}
