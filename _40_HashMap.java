// HashMap Implementation

import java.util.ArrayList;
import java.util.LinkedList;

public class _40_HashMap {
    static class HashMap2<K, V> { // (K,V) parameters type : generics
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // n -> nodes
        private int N; // N -> buckets
        private LinkedList<Node> buckets[]; // N = buckets.length

        @SuppressWarnings("unchecked")
        public HashMap2() {
            this.N = 4;
            this.buckets = new LinkedList[4];

            for (int i = 0; i < buckets.length; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                for (Node nodeK : buckets[i]) {
                    keys.add(nodeK.key);
                }
            }
            return keys;
        }

        public int size() {
            int mapSize = 0;
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    mapSize++;
                }

            }
            return mapSize;
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public V remove(K key) {
            int bi = hashIt(key);
            int di = searchInAll(key, bi);

            if (di == -1) {
                return null;
            } else {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        public boolean containsKey(K key) {
            int bi = hashIt(key);
            int di = searchInAll(key, bi);

            return di != -1;
        }

        public V get(K key) {
            int bi = hashIt(key);
            int di = searchInAll(key, bi);

            if (di == -1) { // key doesn't exists
                return null;
            } else { // key exists
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        public void put(K key, V value) {
            int bi = hashIt(key); // bi -> bucket idx
            int di = searchInAll(key, bi); // di -> data idx

            if (di == -1) { // key doesn't exist
                buckets[bi].add(new Node(key, value));
                n++;
            } else {// key exists
                Node data = buckets[bi].get(di);
                data.value = value;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {
                // rehashing
                rehash();
            }
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N * 2];
            N = N * 2;

            for (int i = 0; i < N * 2; i++) {
                buckets[i] = new LinkedList<>();
            }
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }

        }

        private int searchInAll(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];

            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i;
                }
            }

            return -1;
        }

        private int hashIt(K key) {
            int bi = key.hashCode(); // return both positive and negative
            return Math.abs(bi) % N; // to make value in between 0 to N-1 which are idxs of buckets
        }

    }

    public static void main(String[] args) {
        HashMap2<String, Integer> map = new HashMap2<>();

        System.out.println(map.isEmpty());

        map.put("India", 120);
        map.put("China", 115);
        map.put("USA", 60);
        map.put("Nepal", 10);

        System.out.println(map.isEmpty());

        System.out.println(map.size());

        System.out.println(map.containsKey("India"));
        System.out.println(map.containsKey("Indonesia"));

        System.out.println(map.get("USA"));
        System.out.println(map.get("Indonesia"));

        System.out.println(map.remove("China"));
        System.out.println(map.containsKey("China"));
        System.out.println(map.size());

        for (String str : map.keySet()) {
            System.out.println(str + " -> " + map.get(str));
        }

    }
}
