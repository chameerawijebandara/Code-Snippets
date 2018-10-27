/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grapth;

import java.util.ArrayList;

/**
 *
 * @author Chameera
 */
public class GraphSearch {

    int state[]; // Gray = -1, White = 0, Black = 1
    int d[];
    int pi[];
    int data[][];

    GraphSearch(int data[][]) {
        this.data = new int[data.length][data.length];

        for (int i = 0; i < data.length; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, data.length);
        }
        this.state = new int[data.length];
        this.d = new int[data.length];
        this.pi = new int[data.length];
    }

    public void BFS(int start) {
        for (int i = 0; i < data.length; i++) {
            state[i] = -1;
            d[i] = Integer.MAX_VALUE;
            pi[i] = -1;
        }

        state[start] = 0;
        d[start] = 0;

        ArrayList<Integer> Q = new ArrayList<Integer>();
        Q.add(start);
        while (!Q.isEmpty()) {
            int temp = Q.remove(0);
            for (int i = 0; i < data.length; i++) {
                if (data[temp][i] == 1 && state[i] == -1) {
                    state[i] = 0;
                    d[i] = d[temp] + 1;
                    pi[i] = temp;
                    Q.add(i);
                }
            }
            state[temp] = 1;
        }
    }

    public void DFS(int start) {
        for (int i = 0; i < data.length; i++) {
            state[i] = -1;
            d[i] = Integer.MAX_VALUE;
            pi[i] = -1;
        }

        state[start] = 0;
        d[start] = 0;

        ArrayList<Integer> Q = new ArrayList<Integer>();
        Q.add(start);
        while (!Q.isEmpty()) {
            int temp = Q.remove(Q.size() - 1);
            for (int i = 0; i < data.length; i++) {
                if (data[temp][i] == 1 && state[i] == -1) {
                    state[i] = 0;
                    d[i] = d[temp] + 1;
                    pi[i] = temp;
                    Q.add(i);
                }
            }
            state[temp] = 1;
        }
    }

    private void printPathTo(int goal) {

        int i = goal;
        while (pi[i] != -1) {
            System.out.print(i + " ");
            i = pi[i];
        }
        System.out.println(i);
    }

    public static void main(String[] args) {

        int data[][] = new int[7][7];

        data[1][2] = 1;
        data[1][2] = 1;
        data[2][5] = 1;
        data[3][5] = 1;
        data[3][6] = 1;
        data[4][2] = 1;
        data[5][4] = 1;
        data[6][6] = 1;

        GraphSearch GS = new GraphSearch(data);

        System.out.println("BFS");
        GS.BFS(1);
        GS.printPathTo(5);
        GS.printPathTo(6);

        System.out.println("DFS");
        GS.BFS(1);
        GS.printPathTo(5);
        GS.printPathTo(6);

    }
}
