package Week_08;

public class ShellSort {
    //时间复杂度O(n^2)，空间复杂度O(1），不稳定
    public int[] shellSort(int[] arr){
        int len = arr.length;
        for (int step = len/2; step > 0; step /= 2){
            for (int i = step; i < len; i++){
                int j = i;
                int current = arr[i];
                while (j - step >= 0 && current < arr[j - step]){
                    arr[j] = arr[j - step];
                    j = j - step;
                }
                arr[j] = current;
            }
        }
        return arr;
    }
}
