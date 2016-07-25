import java.util.PriorityQueue;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 26/4/2016.
 */
public class UglyNumberTwo {
    public int nthUglyNumber(int n) {

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        priorityQueue.add((long) 1);
        priorityQueue.add((long) 2);
        priorityQueue.add((long) 3);
        priorityQueue.add((long) 5);

        int index = 0;
        while (!priorityQueue.isEmpty()) {
            Long current = priorityQueue.poll();

            if (!priorityQueue.contains(current * 2)) {
                priorityQueue.add(current * 2);
            }

            if (!priorityQueue.contains(current * 3)) {
                priorityQueue.add(current * 3);
            }

            if (!priorityQueue.contains(current * 5)) {
                priorityQueue.add(current * 5);
            }

            index += 1;

            if (index == n) {
                return current.intValue();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        UglyNumberTwo uglyNumberTwo = new UglyNumberTwo();
        int result = uglyNumberTwo.nthUglyNumber(1407);
        System.out.println();
    }
}
