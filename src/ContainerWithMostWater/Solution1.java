package ContainerWithMostWater;

/**
 * Authored by GongLi at 16:37 on 1/3/14
 */


public class Solution1 {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int ans = 0;
        int tmp = 0;

        int l = 0;
        int r = height.length - 1;
        while (l < r)
        {
            int min = Math.min(height[l], height[r]);
            tmp = min * (r - l);
            if (tmp > ans) ans = tmp;
            if ( height[l] < height[r])
            {
                int last = height[l];
                while (l < r && height[l] <= last)
                {
                    l++;
                }
            }
            else
            {
                int last = height[r];
                while (l < r && height[r] <= last)
                {
                    r--;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] heights = {2, 5, 1, 2, 3, 4, 7, 7, 6};
        Solution1 s = new Solution1();
        System.out.println(s.maxArea(heights));
    }
}
