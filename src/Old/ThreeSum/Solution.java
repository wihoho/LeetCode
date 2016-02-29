package Old.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Authored by GongLi at 17:14 on 1/3/14
 */


public class Solution {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if(num == null || num.length <= 2) return result;

        Arrays.sort(num);
        int size = num.length;

        for(int i = 0; i <= size - 3; i ++ ){
            if(i > 0 && num[i] == num[i-1])
                continue;

            int low = i + 1;
            int high = size - 1;

            while (low < high){
                int sum = num[i] + num[low] + num[high];
                if(sum == 0){
                    ArrayList<Integer> cur = new ArrayList<Integer>();
                    cur.add(num[i]);
                    cur.add(num[low]);
                    cur.add(num[high]);

                    result.add(cur);



                    low ++;
                    while(low < size-2 && num[low - 1] == num[low])
                        low ++;

                    high --;
                    while(high > i && num[high + 1] == num[high])
                        high --;


                }

                else if(sum > 0)
                    high --;

                else
                    low ++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr = {-2,0,1,1,2};
        s.threeSum(arr);

        System.out.println();
    }
}
