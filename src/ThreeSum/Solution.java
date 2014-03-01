package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Authored by GongLi at 17:14 on 1/3/14
 */


public class Solution {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

        if(num == null || num.length <= 2) return null;

        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int size = num.length;
        for(int i = 0; i <= size - 3; i ++ ){
            int low = i + 1;
            int high = size - 1;

            while (low < high){
                if(num[i] + num[low] + num[high] == 0){
                    ArrayList<Integer> cur = new ArrayList<Integer>();
                    cur.add(num[i]);
                    cur.add(num[low]);
                    cur.add(num[high]);

                    result.add(cur);
                }

                else if(num[i] + num[low] + num[high] > 0)
                    high --;

                else
                    low ++;
            }
        }
        return result;

    }
}
