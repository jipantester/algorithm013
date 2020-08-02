package Week_01;

/**
 * @author jipan
 * @version 1.0
 * @date 2020/8/2 19:14
 */
public class SolutionOfRemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
