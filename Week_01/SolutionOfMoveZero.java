package Week_01;

/**
 * @author jipan
 * @version 1.0
 * @date 2020/8/2 19:10
 */
public class SolutionOfMoveZero {
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                //swap(nums[i],nums[j]);
                j++;
            }
        }
    }
}
