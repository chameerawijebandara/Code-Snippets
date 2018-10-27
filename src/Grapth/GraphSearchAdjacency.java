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
public class GraphSearchAdjacency {

    int state[]; // Gray = -1, White = 0, Black = 1
    int d[];
    int pi[];

    ArrayList<Integer> data[];

    GraphSearchAdjacency(int n) {
        this.data = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            this.data[i] = new ArrayList<Integer>();
        }

        this.state = new int[n];
        this.d = new int[n];
        this.pi = new int[n];
    }

    public void addEdge(int v, int w) {
        data[v].add(w);
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

            for (int i = 0; i < data[temp].size(); i++) {
                int next = data[temp].get(i);
                if (state[next] == -1) {
                    state[next] = 0;
                    d[next] = d[temp] + 1;
                    pi[next] = temp;
                    Q.add(next);
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
        data[1][4] = 1;
        data[2][5] = 1;
        data[3][5] = 1;
        data[3][6] = 1;
        data[4][2] = 1;
        data[5][4] = 1;
        data[6][6] = 1;

        GraphSearchAdjacency GS = new GraphSearchAdjacency(7);

        GS.addEdge(1, 2);
        GS.addEdge(1, 4);
        GS.addEdge(2, 5);
        GS.addEdge(3, 5);
        GS.addEdge(3, 6);
        GS.addEdge(4, 2);
        GS.addEdge(5, 4);
        GS.addEdge(6, 6);

        GS.BFS(1);
        GS.printPathTo(5);
        GS.printPathTo(6);

    }
}
