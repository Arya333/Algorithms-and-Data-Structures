
package AlgorithmsandDataStructures;

import java.util.Arrays;


public class MergeSort {
    
    //this method uses recursion to create 2 sorted left & right subarrays
    //n is size of array
    public void mergeSort(int[] array, int n){
        //base case for recursion (size of array is 1 or 0)
        if (n < 2){
            return;
        }
        //find middle index of array and make 2 subarrays
        int mid = n/2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        
        //add values to left & right subarrays from original array
        for (int i = 0; i < mid; i++){
            l[i] = array[i];
        }
        for (int i = mid; i < n; i++){
            r[i - mid] = array[i];
        }
        
        //recursion calls that split subarrays further until base case is reached and creates sorted left & right subarrays
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        
        //calls merge method to combine the 2 sorted subarrays
        merge(array, l, r, mid, n - mid);
    }
    
    //this method combines the sorted subarrays into one sorted array
    public void merge(int[] array, int[] l, int[] r, int left, int right){
        //i is index for left subarray, j is for right subarray and k is for main array
        int i = 0, j = 0, k = 0;
        //while indexes haven't parsed through either subarray (both left & right subarrays haven't fully been parsed through)
        //add whichever value is smallest to main array and increment those indices
        while (i < left && j < right){
            if (l[i] <= r[j]) {
                array[k++] = l[i++];
        }
            else {
                array[k++] = r[j++];
            }
        }
        
        //once either left or right subarray has been fully parsed through, add remaining values of whichever subarray is remaining to the main array
        while (i < left) {
            array[k++] = l[i++];
        }
        while (j < right) {
            array[k++] = r[j++];
        }
    }
    
    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int[] test = {4, 6, 8, 10, 17, 34, 25, 89, 34, 90, 101, 45};
        m.mergeSort(test, 12);
        System.out.println(Arrays.toString(test));
        
    }
}
