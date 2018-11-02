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
public class UniformCostSearch_8Puzzle {

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
    private ArrayList<Node> frontier;
    private ArrayList<Node> explored;

    public UniformCostSearch_8Puzzle(State goal) {
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

            if (temp.state.equals(goal)) {
                return temp;
            }

            explored.add(temp);

            int i = temp.state.i;
            int j = temp.state.j;

            if (i > 0) {
                Node tempL = new Node();
                tempL.state = new State(temp.state.data.length);
                for (int k = 0; k < temp.state.data.length; k++) {
                    System.arraycopy(temp.state.data[k], 0, tempL.state.data[k], 0, temp.state.data[k].length);
                }
                int p = tempL.state.data[i][j];
                tempL.state.data[i][j] = tempL.state.data[i - 1][j];
                tempL.state.data[i - 1][j] = p;
                tempL.state.i = i - 1;
                tempL.state.j = j;

                tempL.cost = temp.cost + 1;
                tempL.action = 0;
                tempL.parent = temp;

                if (!frontier.contains(tempL) && !explored.contains(tempL)) {
                    frontier.add(tempL);
                }
            }

            if (i < temp.state.data.length - 1) {
                Node tempR = new Node();
                tempR.state = new State(temp.state.data.length);
                for (int k = 0; k < temp.state.data.length; k++) {
                    System.arraycopy(temp.state.data[k], 0, tempR.state.data[k], 0, temp.state.data[k].length);
                }
                int p = tempR.state.data[i][j];
                tempR.state.data[i][j] = tempR.state.data[i + 1][j];
                tempR.state.data[i + 1][j] = p;
                tempR.state.i = i + 1;
                tempR.state.j = j;

                tempR.cost = temp.cost + 1;
                tempR.action = 1;
                tempR.parent = temp;

                if (!frontier.contains(tempR) && !explored.contains(tempR)) {
                    frontier.add(tempR);
                }
            }
            if (j > 0) {
                Node tempT = new Node();
                tempT.state = new State(temp.state.data.length);
                for (int k = 0; k < temp.state.data.length; k++) {
                    System.arraycopy(temp.state.data[k], 0, tempT.state.data[k], 0, temp.state.data[k].length);
                }
                int p = tempT.state.data[i][j];
                tempT.state.data[i][j] = tempT.state.data[i][j - 1];
                tempT.state.data[i][j - 1] = p;
                tempT.state.i = i;
                tempT.state.j = j - 1;

                tempT.cost = temp.cost + 1;
                tempT.action = 2;
                tempT.parent = temp;

                if (!frontier.contains(tempT) && !explored.contains(tempT)) {
                    frontier.add(tempT);
                }
            }

            if (j < temp.state.data[i].length - 1) {
                Node tempB = new Node();
                tempB.state = new State(temp.state.data.length);
                for (int k = 0; k < temp.state.data.length; k++) {
                    System.arraycopy(temp.state.data[k], 0, tempB.state.data[k], 0, temp.state.data[k].length);
                }
                int p = tempB.state.data[i][j];
                tempB.state.data[i][j] = tempB.state.data[i][j + 1];
                tempB.state.data[i][j + 1] = p;
                tempB.state.i = i;
                tempB.state.j = j + 1;

                tempB.cost = temp.cost + 1;
                tempB.action = 3;
                tempB.parent = temp;

                if (!frontier.contains(tempB) && !explored.contains(tempB)) {
                    frontier.add(tempB);
                }
            }
        }
    }

    public static void main(String[] args) {

        State init = new State(3);
        State goal = new State(3);

        init.data[0][0] = 7;
        init.data[0][1] = 2;
        init.data[0][2] = 4;
        init.data[1][0] = 5;
        init.data[1][1] = 0;
        init.data[1][2] = 6;
        init.data[2][0] = 8;
        init.data[2][1] = 3;
        init.data[2][2] = 1;

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
        init.j = 1;

        goal.i = 2;
        goal.j = 2;

        UniformCostSearch_8Puzzle bfs = new UniformCostSearch_8Puzzle(goal);
        Node node = bfs.search(init);

        while (node != null) {

            for (int[] data : node.state.data) {
                for (int j = 0; j < data.length; j++) {
                    System.out.print(data[j] + " ");
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
