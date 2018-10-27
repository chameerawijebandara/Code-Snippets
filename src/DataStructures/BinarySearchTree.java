/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 *
 * @author Chameera
 */
public class BinarySearchTree {

    class Node {

        int data;
        Node left;
        Node right;
        Node parent;

        public Node(int x) {
            this.data = x;
            this.left = null;
            this.right = null;
            this.parent = null;

        }

        public Node() {
            this.left = null;
            this.right = null;
            this.parent = null;
        }

    }

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void TreeInsert(int z) {

        Node newNode = new Node(z);
        Node it = root;
        Node parent = null;

        while (it != null) {
            parent = it;
            if (newNode.data < it.data) {
                it = it.left;
            } else {
                it = it.right;
            }
        }
        newNode.parent = parent;

        //Empty tree
        if (parent == null) {
            this.root = newNode;
        } else {
            if (newNode.data < parent.data) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }
    }

    public void inorderTreeWalk() {
        inorderTreeWalk(root);
        System.out.println("");
    }

    private void inorderTreeWalk(Node x) {
        if (x != null) {
            inorderTreeWalk(x.left);
            System.out.print(x.data + " ");
            inorderTreeWalk(x.right);
        }
    }

    public void preorderTreeWalk() {
        preorderTreeWalk(root);
        System.out.println("");
    }

    private void preorderTreeWalk(Node x) {
        if (x != null) {
            System.out.print(x.data + " ");
            preorderTreeWalk(x.left);
            preorderTreeWalk(x.right);
        }
    }

    public void postorderTreeWalk() {
        postorderTreeWalk(root);
        System.out.println("");
    }

    private void postorderTreeWalk(Node x) {
        if (x != null) {
            postorderTreeWalk(x.left);
            postorderTreeWalk(x.right);
            System.out.print(x.data + " ");
        }
    }

    public Node treeSearch(int k) {
        return treeSearch(root, k);
    }

    private Node treeSearch(Node x, int k) {
        if (x == null) {
            return null;
        }
        if (k == x.data) {
            return x;
        }
        if (k < x.data) {
            return treeSearch(x.left, k);
        }
        return treeSearch(x.right, k);
    }

    public Node iterativeTreeSearch(int k) {
        return treeSearch(root, k);
    }

    private Node iterativeTreeSearch(Node x, int k) {

        while (x != null && k == x.data) {
            if (k < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return x;
    }

    public int treeMinimum() {
        return treeMinimum(root);
    }

    private int treeMinimum(Node x) {
        while (x.left != null) {
            x = x.left;
        }
        return x.data;
    }

    public int treeMaximum() {
        return treeMaximum(root);
    }

    private int treeMaximum(Node x) {
        while (x.right != null) {
            x = x.right;
        }
        return x.data;
    }

    public int treeSuccessor(int x) {
        Node temp = treeSearch(x);
        if (temp != null) {
            return treeSuccessor(temp);
        }
        return Integer.MIN_VALUE;

    }

    private int treeSuccessor(Node x) {
        if (x.right != null) {
            return treeMinimum(x.right);
        }
        Node temp = x.parent;
        while (temp != null && x.data == temp.right.data) {
            x = temp;
            temp = temp.parent;
        }
        if (temp != null) {
            return temp.data;
        }
        return Integer.MIN_VALUE;
    }

    public int treePredecessor(int x) {
        Node temp = treeSearch(x);
        if (temp != null) {
            return treePredecessor(temp);
        }
        return Integer.MIN_VALUE;

    }

    private int treePredecessor(Node x) {
        if (x.left != null) {
            return treeMaximum(x.left);
        }
        Node temp = x.parent;
        while (temp != null && x.data == temp.left.data) {
            x = temp;
            temp = temp.parent;
        }
        if (temp != null) {
            return temp.data;
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        BinarySearchTree BST = new BinarySearchTree();

        BST.TreeInsert(20);
        BST.TreeInsert(25);
        BST.TreeInsert(10);
        BST.TreeInsert(1);
        BST.TreeInsert(100);

        BST.inorderTreeWalk();
        BST.preorderTreeWalk();
        BST.postorderTreeWalk();

        Node ans = BST.treeSearch(20);
        if (ans != null) {
            System.out.println(ans.data);
        } else {
            System.out.println("NOT FOUND");
        }

        ans = BST.treeSearch(200);
        if (ans != null) {
            System.out.println(ans.data);
        } else {
            System.out.println("NOT FOUND");
        }

        ans = BST.iterativeTreeSearch(20);
        if (ans != null) {
            System.out.println(ans.data);
        } else {
            System.out.println("NOT FOUND");
        }

        ans = BST.iterativeTreeSearch(200);
        if (ans != null) {
            System.out.println(ans.data);
        } else {
            System.out.println("NOT FOUND");
        }

        System.out.println(BST.treeMinimum());
        System.out.println(BST.treeMaximum());

        int p = BST.treeSuccessor(10);
        if (p != Integer.MIN_VALUE) {
            System.out.println(p);
        } else {
            System.out.println("NOT FOUND");
        }

        p = BST.treePredecessor(20);
        if (p != Integer.MIN_VALUE) {
            System.out.println(p);
        } else {
            System.out.println("NOT FOUND");
        }

    }
}
