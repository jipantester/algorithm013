package Week_08;

public class BubbleSort {
    //时间复杂度O(n^2)，空间复杂度O(1)，稳定
    public int[] bubbleSort(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len - 1; i++){
            for (int j = 0; j < len - 1 -i; j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
