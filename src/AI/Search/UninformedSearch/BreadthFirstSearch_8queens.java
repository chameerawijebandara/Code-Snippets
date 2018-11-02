/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI.Search.UninformedSearch;

import java.util.ArrayList;

/**
 *
 * @author Chameera
 */
public class BreadthFirstSearch_8queens {

    private static class State {

        int data[][];

        public State(Object b) {

        }

        public State(int size) {
            data = new int[size][size];
        }

        @Override
        public boolean equals(Object b) {
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    if (data[i][j] != ((State) b).data[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private static class Node {

        State state;
        Node parent;
        int action;
        int cost;

        @Override
        public boolean equals(Object b) {
            return this.state.equals(((Node) b).state);
        }
    }

    private int goal;
    private ArrayList<Node> frontier;
    private ArrayList<Node> explored;

    public BreadthFirstSearch_8queens(int goal) {

        this.goal = goal;
        this.frontier = new ArrayList<Node>();
        this.explored = new ArrayList<Node>();
    }

    public Node search(State initialState) {
        Node temp = new Node();
        temp.state = initialState;
        temp.cost = 0;
        temp.action = -1;
        temp.parent = null;

        frontier.add(temp);

        while (true) {
            if (this.frontier.isEmpty()) {
                return null;
            }
            temp = this.frontier.remove(0);

            if (temp.cost == this.goal) {
                return temp;
            }

            explored.add(temp);

//            System.out.println(temp.cost);
//            for (int i = 0; i < temp.state.data.length; i++) {
//                for (int j = 0; j < temp.state.data[i].length; j++) {
//                    System.out.print(temp.state.data[i][j] + " ");
//                }
//                System.out.println("");
//            }

            for (int i = 0; i < this.goal; i++) {
                int hold[][] = new int[this.goal][this.goal];

                for (int j = 0; j < hold.length; j++) {
                    for (int k = 0; k < hold[j].length; k++) {
                        hold[j][k] = temp.state.data[j][k];
                    }
                }

                hold[i][temp.cost] = 1;

                int x = i - 1;
                boolean isGood = true;
                for (int j = temp.cost - 1; j >= 0 && x >= 0; j--, x--) {

                    if (hold[x][j] == 1) {
                        isGood = false;
                        break;
                    }

                }
                if (!isGood) {
                    continue;
                }

                x = i;
                for (int j = temp.cost - 1; j >= 0; j--) {
                    if (hold[x][j] == 1) {
                        isGood = false;
                        break;
                    }
                }

                if (!isGood) {
                    continue;
                }

                x = i + 1;
                for (int j = temp.cost - 1; j >= 0 && x < this.goal; j--, x++) {

                    if (hold[x][j] == 1) {
                        isGood = false;
                        break;
                    }

                }
                if (isGood) {
                    Node node = new Node();
                    node.state = new State(this.goal);
                    node.state.data = hold;
                    node.parent = temp;
                    node.cost = temp.cost + 1;

                    if (!frontier.contains(node) && !explored.contains(node)) {
                        this.frontier.add(node);
                    }

                }
            }
        }
    }

    public static void main(String[] args) {

        int SIZE = 10;
        State init = new State(SIZE);

        BreadthFirstSearch_8queens bfs = new BreadthFirstSearch_8queens(SIZE);
        Node node = bfs.search(init);

        if (node != null) {
            
            

            for (int i = 0; i < node.state.data.length; i++) {
                for (int j = 0; j < node.state.data[i].length; j++) {
                    System.out.print(node.state.data[i][j] + " ");
                }
                System.out.println("");
            }
        }
    }
}
