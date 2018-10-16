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
public class HeapSort {

    private static int heapSize;

    private static int patent(int i) {
        return (i - 1) / 2;
    }

    private static int left(int i) {
        return 2 * i + 1;
    }

    private static int right(int i) {
        return 2 * (i + 1);
    }

    private static void maxHeapify(int in[], int i) {
        int l = left(i);
        int r = right(i);

        int largest = i;
        if (l < heapSize && in[l] > in[i]) {
            largest = l;
        }

        if (r < heapSize && in[r] > in[largest]) {
            largest = r;
        }

        if (largest != i) {
            int temp = in[i];
            in[i] = in[largest];
            in[largest] = temp;

            maxHeapify(in, largest);
        }
    }

    private static void buildMaxHeap(int in[]) {
        heapSize = in.length;
        for (int i = in.length / 2; i >= 0; i--) {
            maxHeapify(in, i);
        }
    }

    public static void sort(int in[]) {
        buildMaxHeap(in);
        for (int i = in.length - 1; i > 0; i--) {
            int temp = in[i];
            in[i] = in[0];
            in[0] = temp;

            heapSize--;
            
            maxHeapify(in, 0);
        }
    }

    public static void main(String[] args) {
        int in[] = {5, 3, 17, 10, 84, 19, 6, 22, 9};

        Util.printArray(in);
        buildMaxHeap(in);
        Util.printArray(in);
        sort(in);
        Util.printArray(in);
    }
}
