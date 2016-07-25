import java.util.ArrayList;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 25/11/2015.
 */
public class Permutations {
    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(2);
        result.add(3);
        ArrayList<ArrayList<Integer>> result1 = permutations.permute(result);
        System.out.println();
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        permuteHelper(nums, new ArrayList<>(), result);
        return result;
    }

    private void permuteHelper(ArrayList<Integer> nums, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        if (current.size() == nums.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (current.contains(nums.get(i))) {
                continue;
            }

            current.add(nums.get(i));
            permuteHelper(nums, current, result);
            current.remove(current.size() - 1);
        }
    }

}
