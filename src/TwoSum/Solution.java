package TwoSum;

import java.util.HashMap;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {

        if(numbers == null || numbers.length < 2) return null;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i ++)
            map.put(numbers[i], i);

        for(int i = 0; i < numbers.length; i ++){
            int temp = target - numbers[i];
            if(map.containsKey(temp) && map.get(temp) != i){
                int[] result = new int[2];
                result[0] = i + 1;
                result[1] = map.get(temp) + 1;

                return result;
            }
        }

        return null;


    }
}