/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI.Search;

import java.util.ArrayList;

/**
 *
 * @author Chameera
 */
public class BreadthFirstSearch_numberProblem {

    private static class State {

        double data;
        boolean isFloat;

        public State(Object b) {

        }

        public State(long data) {
            this.data = data;
            this.isFloat = false;
        }

        public State(int data) {
            this.data = data;
            this.isFloat = false;
        }

        public State(float data) {
            this.data = data;
            this.isFloat = true;
        }

        public State(double data) {
            this.data = data;
            this.isFloat = true;
        }

        @Override
        public boolean equals(Object b) {
            return this.data == ((State) b).data;
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

    public BreadthFirstSearch_numberProblem(State goal) {
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

            if (!temp.state.isFloat) {
                if (temp.state.data < 20) {
                    Node nextF = new Node();
                    long fac = 1;
                    for (int i = 2; i <= temp.state.data; i++) {
                        fac *= i;
                    }
                    nextF.state = new State(fac);
                    nextF.cost = temp.cost + 1;
                    nextF.action = 1;
                    nextF.parent = temp;

                    if (!frontier.contains(nextF) && !explored.contains(nextF)) {
                        frontier.add(nextF);
                    }
                }
            } else {
                Node nextF = new Node();

                nextF.state = new State(Math.floor(temp.state.data));
                nextF.state.isFloat = false;
                nextF.cost = temp.cost + 1;
                nextF.action = 2;
                nextF.parent = temp;

                if (!frontier.contains(nextF) && !explored.contains(nextF)) {
                    frontier.add(nextF);
                }
            }

            Node nextS = new Node();

            nextS.state = new State(Math.sqrt(temp.state.data));
            nextS.state.isFloat = (nextS.state.data * nextS.state.data != temp.state.data);

            nextS.cost = temp.cost + 1;
            nextS.action = 3;
            nextS.parent = temp;

            if (!frontier.contains(nextS) && !explored.contains(nextS)) {
                frontier.add(nextS);
            }

        }
    }

    public static void main(String[] args) {

        State init = new State(50);
        State goal = new State(4);

        BreadthFirstSearch_numberProblem BFS = new BreadthFirstSearch_numberProblem(goal);

        Node ans = BFS.search(init);

        if (ans != null) {
            while (ans.cost != 0) {
                System.out.print(ans.state.data + " ");

                switch (ans.action) {
                    case 1:
                        System.out.println("!");
                        break;
                    case 2:
                        System.out.println("FLOOR");
                        break;
                    case 3:
                        System.out.println("SQRT");
                        break;

                }
                ans = ans.parent;
            }
        }
        System.out.println(init.data);
    }
}
