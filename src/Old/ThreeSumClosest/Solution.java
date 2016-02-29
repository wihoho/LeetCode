package Old.ThreeSumClosest;

import java.util.Arrays;

/**
 * Authored by GongLi at 21:59 on 1/3/14
 */


public class Solution {

    public int threeSumClosest(int[] num, int target) {

        int minDiff = Integer.MAX_VALUE;
        int size = num.length;

        int  resultValue = -1;

        Arrays.sort(num);

        for(int i = 0; i <= size - 3; i ++){
            int start = i + 1;
            int end = size - 1;

            while(start < end){
                int sum = num[i] + num[start] + num[end];
                if(minDiff > Math.abs(sum - target)){
                    minDiff = Math.abs(sum - target);
                    resultValue = sum;
                }

                if(sum < target)
                    start ++;
                else if(sum > target)
                    end --;
                else
                    return target;

            }
        }

        return resultValue;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,1,1,0};
        s.threeSumClosest(nums, 100);
    }


}
