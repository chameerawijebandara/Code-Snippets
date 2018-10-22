/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates/
 * and open the template in the editor.
 */
package OrderStatistics;

import Util.Util;

/**
 *
 * @author Chameera
 */
public class RandomizedSelect {

    private static int randomizedSelect(int in[], int p, int r, int i) {
        if (p == r - 1) {
            return in[p];
        }
        int q = randomizedPartition(in, p, r);

        int k = q - p;

        if (i == k) {
            return in[q];
        } else if (i < k) {
            return randomizedSelect(in, p, q, i);
        }

        return randomizedSelect(in, q + 1, r, i - k);

    }

    private static int select(int in[], int p, int r, int i) {
        if (p == r - 1) {
            return in[p];
        }
        int q = partition(in, p, r);

        int k = q - p;

        if (i == k) {
            return in[q];
        } else if (i < k) {
            return select(in, p, q, i);
        }

        return select(in, q + 1, r, i - k);

    }

    private static int randomizedPartition(int in[], int p, int r) {
        int i = p + (int) (Math.random() * (r - p - 1));
        int temp = in[i];
        in[i] = in[r - 1];
        in[r - 1] = temp;

        return partition(in, p, r);
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

    public static int randomizedSelect(int in[], int i) {
        return randomizedSelect(in, 0, in.length, i);
    }

    public static int select(int in[], int i) {
        return select(in, 0, in.length, i);
    }

    public static void main(String[] args) {
        int in[] = {5, 3, 17, 10, 84, 19, 6, 22, 9};

        Util.printArray(in);
        System.out.println(select(in, 2));
    }
}
