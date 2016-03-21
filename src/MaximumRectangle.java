import java.util.Arrays;
import java.util.Stack;

/**
 * Created by wihoho on 12/3/16.
 */
public class MaximumRectangle {

    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length ==0) return maxArea;


        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        for(int i = 0; i < n; i ++) {
            if (matrix[0][i] == '1') {
                heights[i] += 1;
            }
        }

        maxArea = largestRectangleArea(heights);
        for(int i  = 1; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

           int cur = largestRectangleArea(heights);
            if (cur  > maxArea) {
                maxArea = cur;
            }
        }

        return maxArea;
    }


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
}
