import java.util.Arrays;
import java.util.Stack;

/**
 * Created by wihoho on 12/3/16.
 */
public class LargestRectangleInHist {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int size = heights.length;
        heights = Arrays.copyOf(heights, size + 1);

        Stack<Integer> indices = new Stack<>();
        int max = 0;
        for(int i = 0; i < heights.length; i ++) {
            while (!indices.isEmpty() && heights[i] < heights[indices.peek()]) {
                int h = heights[indices.pop()];
                int w = indices.isEmpty() ? i : i - indices.peek() -1;
                max = h*w > max? h*w:max;
            }

            indices.push(i);
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
