package Week_08;

public class SelectionSort {
    //时间复杂度O(n^2)；空间复杂度O(1)，不稳定
    public int[] selectionSort(int[] arr){
        int len = arr.length;
        int minindex, temp;
        for (int i = 0; i < len; i++){
            minindex = i;
            for (int j = i + 1; j < len ; j++){
                if (arr[j] < arr[minindex]) {
                    minindex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minindex];
            arr[minindex] = temp;
        }
        return arr;
    }
}
