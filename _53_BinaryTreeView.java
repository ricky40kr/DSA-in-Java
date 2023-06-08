/*
         5
        / \
       1   7
      / \  /
     2  4/8 <- 4 and 8 are on top of each other so we take left most one which is 8
       /  \
     3     6 <- 6 hides 7 in bottomView
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

public class _53_BinaryTreeView {

    public static void main(String[] args) {
        Node five = new Node(5);
        Node one = new Node(1);
        Node two = new Node(2);
        Node four = new Node(4);
        Node three = new Node(3);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);

        // join
        five.left = one;
        five.right = seven;
        one.left = two;
        one.right = four;
        four.left = three;
        four.right = six;
        seven.left = eight;

        Node root = five;

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        // left view

        leftComputeView(root, map, 0);
        for (int i = 0; i < map.size(); i++) {
            list.add(map.get(i));
        }
        System.out.println("left View : " + list);

        list = new ArrayList<>();

        // right view
        rightComputeView(root, map, 0);
        for (int i = 0; i < map.size(); i++) {
            list.add(map.get(i));
        }
        System.out.println("Right View : " + list);

        // top view
        System.out.println("Top View : " + topComputeView(root));

        // bottom view
        System.out.println("Bottom View : " + bottomComputeView(root));
    }

    static void rightComputeView(Node root, Map<Integer, Integer> map, int level) {
        if (root == null)
            return;

        // Add the root value to the map at the current level
        map.put(level, root.data);

        // for left view just flip the below recursive statments
        rightComputeView(root.left, map, level + 1);
        rightComputeView(root.right, map, level + 1);
    }

    static void leftComputeView(Node root, Map<Integer, Integer> map, int level) {
        if (root == null)
            return;

        // Add the root value to the map at the current level
        map.put(level, root.data);

        // for left view just flip the below recursive statments
        leftComputeView(root.right, map, level + 1);
        leftComputeView(root.left, map, level + 1);
    }

    static ArrayList<Integer> topComputeView(Node root) {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>(); // 1->d 2->node.data

        q.add(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            if (!map.containsKey(cur.d))
                map.put(cur.d, cur.node.data);

            if (cur.node.left != null)
                q.add(new Pair(cur.d - 1, cur.node.left));

            if (cur.node.right != null)
                q.add(new Pair(cur.d + 1, cur.node.right));
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i : map.keySet()) {
            list.add(map.get(i));
        }

        return list;

    }

    static ArrayList<Integer> bottomComputeView(Node root) {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>(); // 1->d 2->node.data

        q.add(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            map.put(cur.d, cur.node.data);

            if (cur.node.left != null)
                q.add(new Pair(cur.d - 1, cur.node.left));

            if (cur.node.right != null)
                q.add(new Pair(cur.d + 1, cur.node.right));
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i : map.keySet()) {
            list.add(map.get(i));
        }

        return list;

    }

    static class Pair {
        Node node;
        int d; // distance 0 1 -1 -2 2...

        public Pair(int d, Node node) {
            this.node = node;
            this.d = d;
        }
    }
}