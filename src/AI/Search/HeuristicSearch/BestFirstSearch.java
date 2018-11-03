/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI.Search.HeuristicSearch;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Chameera
 */
public class BestFirstSearch {

    private static class State {

        int city;

        public State(Object b) {

        }

        public State(int city) {
            this.city = city;
        }

        @Override
        public boolean equals(Object b) {
            return city == ((State) b).city;
        }
    }

    private static class Node implements Comparable<Node> {

        State state;
        Node parent;
        int pathCost;
        int huristicCost;

        @Override
        public boolean equals(Object b) {
            return this.state.equals(((Node) b).state);
        }

        @Override
        public int compareTo(Node o) {
            return this.huristicCost - o.huristicCost;
        }
    }

    private int goal;
    private int[][] map;
    private PriorityQueue<Node> frontier;
    private ArrayList<Node> explored;

    public BestFirstSearch(int data[][], int goal) {

        this.goal = goal;
        this.frontier = new PriorityQueue<Node>();
        this.explored = new ArrayList<Node>();
        this.map = new int[data.length][data.length];

        for (int i = 0; i < data.length; i++) {
            System.arraycopy(data[i], 0, this.map[i], 0, data[i].length);
        }
    }

    /**
     * Values of hSLD—straight-line distances to Bucharest.
     *
     * @param x
     * @return
     */
    private int huristicCost(int x) {
        /**
         *
         * Arad(0) 366 Bucharest(1) 0 Craiova(2) 160 Drobeta(3) 242 Eforie(4)161
         * Fagaras(5) 176 Giurgiu(6) 77 Hirsova(7) 151 Iasi(8) 226 Lugoj(9) 244
         * Mehadia(10) 241 Neamt(11) 234 Oradea(12) 380 Pitesti(13) 100 Rimnicu
         * Vilcca(14) 193 Sibiu(15) 253 Timisoara(16) 329 Uraziceni(17) 80
         * Vaslui(18) 199 Zerind(19) 374
         *
         */

        int cost[] = {366, 0, 160, 242, 161, 176, 77, 151, 226, 244, 241, 234, 380, 100, 193, 253, 329, 80, 199, 374};
        return cost[x];

    }

    private static String getCity(int x) {
        String cities[] = {"Arad(0)", "Bucharest(1)", "Craiova(2)",
            "Drobeta(3)", "Eforie(4)", "Fagaras(5)", "Giurgiu(6)", "Hirsova(7)",
            "Iasi(8)", "Lugoj(9)", "Mehadia(10)", "Neamt(11)", "Oradea(12)",
            "Pitesti(13)", "Rimnicu Vilcca(14)", "Sibiu(15)", "Timisoara(16)",
            "Uraziceni(17)", "Vaslui(18)", "Zerind(19)"};

        return cities[x];
    }

    public Node search(State initialState) {
        Node temp = new Node();
        temp.state = initialState;
        temp.pathCost = 0;
        temp.parent = null;

        frontier.add(temp);

        while (true) {
            if (this.frontier.isEmpty()) {
                return null;
            }
            temp = this.frontier.poll();

            if (temp.state.city == this.goal) {
                return temp;
            }

            explored.add(temp);

            for (int i = 0; i < this.map.length; i++) {
                if (this.map[temp.state.city][i] > 0) {

                    Node node = new Node();
                    node.state = new State(i);
                    node.parent = temp;
                    node.pathCost = temp.pathCost + this.map[temp.state.city][i];
                    node.huristicCost = huristicCost(i);

                    if (!frontier.contains(node) && !explored.contains(node)) {
                        this.frontier.add(node);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        int map[][] = new int[20][20];

        map[0][15] = 140;
        map[0][16] = 118;
        map[0][19] = 75;

        map[1][5] = 211;
        map[1][6] = 90;
        map[1][13] = 101;
        map[1][17] = 85;

        map[2][3] = 120;
        map[2][13] = 138;
        map[2][14] = 146;

        map[3][2] = 120;
        map[3][10] = 75;

        map[4][7] = 86;

        map[5][1] = 211;
        map[5][15] = 99;

        map[6][1] = 90;

        map[7][4] = 86;
        map[7][17] = 98;

        map[8][11] = 87;
        map[8][18] = 92;

        map[9][10] = 70;
        map[9][16] = 111;

        map[10][3] = 75;
        map[10][9] = 70;

        map[11][8] = 87;

        map[12][15] = 151;
        map[12][19] = 71;

        map[13][1] = 101;
        map[13][2] = 138;
        map[13][14] = 97;

        map[14][2] = 146;
        map[14][13] = 97;
        map[14][15] = 80;

        map[15][0] = 140;
        map[15][5] = 99;
        map[15][12] = 151;
        map[15][14] = 80;

        map[16][0] = 118;
        map[16][9] = 111;

        map[17][1] = 85;
        map[17][7] = 89;
        map[17][18] = 142;

        map[18][17] = 142;
        map[18][8] = 92;

        map[19][0] = 75;
        map[19][12] = 71;

        State init = new State(0);
        BestFirstSearch bfs = new BestFirstSearch(map, 1);
        Node node = bfs.search(init);

        while (node != null) {

            System.out.println(getCity(node.state.city) + " " + node.pathCost);
            node = node.parent;
        }
    }
}
