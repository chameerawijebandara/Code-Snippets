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
public class DepthFirstSearchRecursive_8Puzzle {

    private static class State {

        int data[][];
        int i;
        int j;

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

    private State goal;

    public DepthFirstSearchRecursive_8Puzzle(State goal) {
        this.goal = goal;
    }

    public Node recursiveSearch(Node node, int limit) {
        if (limit == 0) {
            return null;
        }
        if (node.state.equals(goal)) {
            return node;
        }

        int i = node.state.i;
        int j = node.state.j;



        if (i > 0) {
            Node tempL = new Node();
            tempL.state = new State(node.state.data.length);
            for (int k = 0; k < node.state.data.length; k++) {
                System.arraycopy(node.state.data[k], 0, tempL.state.data[k], 0, node.state.data[k].length);
            }
            int p = tempL.state.data[i][j];
            tempL.state.data[i][j] = tempL.state.data[i - 1][j];
            tempL.state.data[i - 1][j] = p;
            tempL.state.i = i - 1;
            tempL.state.j = j;

            tempL.cost = node.cost + 1;
            tempL.action = 0;
            tempL.parent = node;

            Node temp = recursiveSearch(tempL, limit - 1);
            if (temp != null) {
                return temp;
            }
        }

        if (i < node.state.data.length - 1) {
            Node tempR = new Node();
            tempR.state = new State(node.state.data.length);
            for (int k = 0; k < node.state.data.length; k++) {
                System.arraycopy(node.state.data[k], 0, tempR.state.data[k], 0, node.state.data[k].length);
            }
            int p = tempR.state.data[i][j];
            tempR.state.data[i][j] = tempR.state.data[i + 1][j];
            tempR.state.data[i + 1][j] = p;
            tempR.state.i = i + 1;
            tempR.state.j = j;

            tempR.cost = node.cost + 1;
            tempR.action = 1;
            tempR.parent = node;

            Node temp = recursiveSearch(tempR, limit - 1);
            if (temp != null) {
                return temp;
            }
        }
        if (j > 0) {
            Node tempT = new Node();
            tempT.state = new State(node.state.data.length);
            for (int k = 0; k < node.state.data.length; k++) {
                System.arraycopy(node.state.data[k], 0, tempT.state.data[k], 0, node.state.data[k].length);
            }
            int p = tempT.state.data[i][j];
            tempT.state.data[i][j] = tempT.state.data[i][j - 1];
            tempT.state.data[i][j - 1] = p;
            tempT.state.i = i;
            tempT.state.j = j - 1;

            tempT.cost = node.cost + 1;
            tempT.action = 2;
            tempT.parent = node;

            Node temp = recursiveSearch(tempT, limit - 1);
            if (temp != null) {
                return temp;
            }
        }

        if (j < node.state.data[i].length - 1) {
            Node tempB = new Node();
            tempB.state = new State(node.state.data.length);
            for (int k = 0; k < node.state.data.length; k++) {
                System.arraycopy(node.state.data[k], 0, tempB.state.data[k], 0, node.state.data[k].length);
            }
            int p = tempB.state.data[i][j];
            tempB.state.data[i][j] = tempB.state.data[i][j + 1];
            tempB.state.data[i][j + 1] = p;
            tempB.state.i = i;
            tempB.state.j = j + 1;

            tempB.cost = node.cost + 1;
            tempB.action = 3;
            tempB.parent = node;

            Node temp = recursiveSearch(tempB, limit - 1);
            if (temp != null) {
                return temp;
            }
        }
        return null;
    }

    public Node search(State initialState, int limit) {
        Node temp = new Node();
        temp.state = initialState;
        temp.cost = 0;
        temp.action = -1;
        temp.parent = null;

        return recursiveSearch(temp, limit);
    }

    public static void main(String[] args) {

        State init = new State(3);
        State goal = new State(3);

        init.data[0][0] = 1;
        init.data[0][1] = 2;
        init.data[0][2] = 3;
        init.data[1][0] = 0;
        init.data[1][1] = 5;
        init.data[1][2] = 6;
        init.data[2][0] = 4;
        init.data[2][1] = 7;
        init.data[2][2] = 8;

        goal.data[0][0] = 1;
        goal.data[0][1] = 2;
        goal.data[0][2] = 3;
        goal.data[1][0] = 4;
        goal.data[1][1] = 5;
        goal.data[1][2] = 6;
        goal.data[2][0] = 7;
        goal.data[2][1] = 8;
        goal.data[2][2] = 0;

        init.i = 1;
        init.j = 0;

        goal.i = 2;
        goal.j = 2;

        DepthFirstSearchRecursive_8Puzzle bfs = new DepthFirstSearchRecursive_8Puzzle(goal);
        Node node = bfs.search(init, 100);

        while (node != null) {

            for (int i = 0; i < node.state.data.length; i++) {
                for (int j = 0; j < node.state.data[i].length; j++) {
                    System.out.print(node.state.data[i][j] + " ");
                }
                System.out.println("");
            }
            switch (node.action) {
                case 0:
                    System.out.println("UP");
                    break;
                case 1:
                    System.out.println("DOWN");
                    break;
                case 2:
                    System.out.println("LEFT");
                    break;
                case 3:
                    System.out.println("RIGHT");
                    break;

            }
            node = node.parent;
        }

    }
}
