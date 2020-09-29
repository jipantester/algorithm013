package Week_08;

public class InsertionSort {
    //时间复杂度O(n^2)，空间复杂度O(1)，稳定
    public int[] insertionSort(int[] arr){
        int len = arr.length;
        int preIndex, current;
        for (int i = 1; i < len; i++){
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current){
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }
}
