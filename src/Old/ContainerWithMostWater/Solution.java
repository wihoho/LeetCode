package Old.ContainerWithMostWater;

/**
 * Authored by GongLi at 16:11 on 1/3/14
 */


public class Solution {
    public int maxArea(int[] height){
        if(height == null || height.length == 0) return 0;

        int heightSize = height.length;
        int[] container = new int[heightSize];
        for(int i = 1; i < heightSize; i ++){
            if(height[i-1] < height[i]){

                int potentialIndex = i -1;
                int currentDif = height[i] - height[i-1];
                for(int j = i - 2; j >=0 && height[j] <height[i]; j--){

                    if(currentDif > (height[i] - height[j])){
                        currentDif = height[i] - height[j];
                        potentialIndex = j;
                    }
                }

                container[i] = container[potentialIndex] + (i - potentialIndex) * height[potentialIndex];
            }
            else{

                container[i] = container[i-1] + height[i];
            }
        }

        return container[heightSize-1];
    }

        public static void main(String[] args) {
            int[] heights = {2, 5, 1, 2, 3, 4, 7, 7, 6};

            Solution s = new Solution();
            System.out.println(s.maxArea(heights));
        }



}
