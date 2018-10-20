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
public class RadixSort {

    private static void radixSort(int in[], int d) {
        
        for (int i = 0; i < d; i++) {
            // use a stable sort to sort array in on digit i
            // use count sort to sort
            int hold[] = new int[10];
            for (int j = 0; j < hold.length; j++) {
                hold[i] = 0;
            }

            for (int j = 0; j < in.length; j++) {
                int temp = (int) ((in[j] % (Math.pow(10, i + 1))) / Math.pow(10, i));
                hold[temp]++;
            }

            for (int j = 1; j < hold.length; j++) {
                hold[j] += hold[j - 1];
            }

            int out[] = new int[in.length];
            // order matters
            for (int j = in.length - 1; j >= 0; j--) {
                int temp = (int) ((in[j] % (Math.pow(10, i + 1))) / Math.pow(10, i));

                out[hold[temp] - 1] = in[j];
                hold[temp]--;

            }
            System.arraycopy(out, 0, in, 0, in.length);

        }
    }

    public static void sort(int in[]) {

        int max = in[0];
        for (int i = 1; i < in.length; i++) {
            if (max < in[i]) {
                max = in[i];
            }
        }
        radixSort(in, (int) (Math.log(max) + 1));
    }

    public static void main(String[] args) {
        int in[] = {329, 457, 657, 839, 436, 720, 355, 1657,1 ,2345, 23};

        Util.printArray(in);
        sort(in);
        Util.printArray(in);
    }
}
