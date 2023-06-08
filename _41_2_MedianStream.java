// Find Median of Running stream of Integers

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // Function to insert heap.
    public void insertHeap(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        balanceHeaps();
    }

    // Function to balance heaps.
    public void balanceHeaps() {
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    // Function to return Median.
    public double getMedian() {
        double ans;

        if (minHeap.size() == maxHeap.size()) {
            ans = (double) (minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            ans = (double) maxHeap.peek();
        }

        return ans;
    }

}

public class _41_2_MedianStream {

    public static void main(String[] args) {
        /*
         * Input -> 5,15,1,3
         * Output -> 5,10,5,4
         * Exmplanation :
         * Flow in stream : 5, 15, 1, 3
         * 5 goes to stream --> median 5 (5)
         * 15 goes to stream --> median 10 (5,15)
         * 1 goes to stream --> median 5 (5,15,1)
         * 3 goes to stream --> median 4 (5,15,1 3)
         */

        Solution collect = new Solution();

        collect.insertHeap(5);
        System.out.print(collect.getMedian() + " ");
        collect.insertHeap(15);
        System.out.print(collect.getMedian() + " ");
        collect.insertHeap(1);
        System.out.print(collect.getMedian() + " ");
        collect.insertHeap(3);
        System.out.print(collect.getMedian() + " ");

    }

}