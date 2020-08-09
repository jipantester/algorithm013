package Week_02;

/**
 * @author jipan
 * @version 1.0
 * @date 2020/8/9 20:12
 */
public class SolutionOfTwoNums {
    public int[] TwoNums(int[] nums, int target){
        int[] arr = new int[2];
        for (int i = 0; i < nums.length-1; i++){
            for (int j = i+1 ; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }
}
