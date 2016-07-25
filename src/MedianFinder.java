import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> {
            return -a.compareTo(b);
        });
        minHeap = new PriorityQueue<>((a, b) -> {
            return a.compareTo(b);
        });
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }

        int m = maxHeap.peek();

        if (minHeap.isEmpty()) {
            if (num < m) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            return;
        }


        int n = minHeap.peek();

        if (num <= m) {
            if (maxHeap.size() > minHeap.size()) {
                maxHeap.poll();
                maxHeap.add(num);
                minHeap.add(m);
            } else {
                maxHeap.add(num);
            }
        } else if (num <= n) {
            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
        } else {
            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(num);
            } else {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }
        }

    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            int m = maxHeap.peek();
            int n = minHeap.peek();
            return (m + n) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
};