import java.util.ArrayList;

// Heap / Priority Queue
// Priority Queue is internally implimented in form of heap in java
// Heap : A Complete Binary Tree that satisfy heap's properties.
// Binary Tree : Tree where each parent node have at most 2 child nodes.
// Complete Binary Tree : It is a binary tree in which all the levels are completely filled except possible the last one, which is filled from the left to right.

// Heap property :
/*
 * A) Max Heap :
 *  i) parentNode >= childNode
 * ii) leftNode >= rightNode
 * 
 * B) Min Heap :
 *  i) parentNode <= childNode
 * ii) leftNode <= rightNode
 */

// To know index (0-indexed array) 
/*
* Heap index start from 1
* for Node = i
* parent(i) = i/2
* child(i)=parent((i-1) / 2)
* left_child(i) = 2i+1
* right_child(i) = 2i+2
*/

// if 1-indexed array then 0th index will have -1 value
/*
* Heap index start from 1
* for Node = i
* parent(i) = i/2
* child(i)=parent((i-1) / 2)
* left_child(i) = 2i
* right_child(i) = 2i+1
*/

// min heap implimented
public class _42_Heap {
    static class Heap {
        private ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data); // add at last ind

            // shuffling to form it heap again

            int child = arr.size() - 1;
            int parent = (child - 1) / 2;

            while (arr.get(parent) > arr.get(child)) { // change > to < for max heap
                // swap
                int temp = arr.get(parent);
                arr.set(parent, arr.get(child));
                arr.set(child, temp);
            }
        }

        public int peek() {
            return arr.get(0);
        }

        // heapify -> O(log n)
        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i; // minIdx is i coz it is min heap and root is min value

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) { // change > to < for max heap
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) { // change > to < for max heap
                minIdx = right;
            }

            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                // recurrsively checking for lower nodes(children)
                heapify(minIdx);
            }

        }

        public int remove() {
            int data = arr.get(0);

            // step-1 -> swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // step-2 -> delete last
            arr.remove(arr.size() - 1);

            // step-3 -> heapify
            heapify(0);

            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(14);
        h.add(0);
        h.add(70);
        h.add(-1);
        h.add(10);
        h.add(100);

        while (!h.isEmpty()) {
            System.out.print(h.peek() + " ");
            h.remove();
        }
    }
}
