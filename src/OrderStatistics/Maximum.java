/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderStatistics;

import Util.Util;

/**
 *
 * @author Chameera
 */
public class Maximum {

    public static int maximum(int in[]) {
        int max = in[0];

        for (int i = 1; i < in.length; i++) {
            if (max < in[i]) {
                max = in[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int in[] = {329, 457, 657, 839, 436, 720, 355, 1657, 1, 2345, 23};

        Util.printArray(in);
        System.out.println(maximum(in));
    }
}
