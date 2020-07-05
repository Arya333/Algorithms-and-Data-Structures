
package AlgorithmsandDataStructures;

import java.util.Arrays;


public class SelectionSort {
    
    /*
        EXAMPLE
        arr[] = 64 25 12 22 11

        Find the minimum element in arr[0...4]
        and place it at beginning
        11 25 12 22 64

        Find the minimum element in arr[1...4]
        and place it at beginning of arr[1...4]
        11 12 25 22 64

        Find the minimum element in arr[2...4]
        and place it at beginning of arr[2...4]
        11 12 22 25 64

        Find the minimum element in arr[3...4]
        and place it at beginning of arr[3...4]
        11 12 22 25 64 
    */
    
    //method sorts the array
    public void sort(int[] array){
        
        int n = array.length;
        //One by one move boundary of unsorted array
        for (int i = 0; i < n-1; i++){
            //find minimum value of unsorted array
            int minIndex = i;
            for(int j = i+1; j < n; j++){
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            //swap min element with first element of unsorted array
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
    
    public static void main(String[] args){
        SelectionSort s = new SelectionSort();
        int[] array = {64, 25, 12, 22, 11};
        s.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
