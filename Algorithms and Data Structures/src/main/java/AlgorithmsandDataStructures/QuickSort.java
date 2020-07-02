
package AlgorithmsandDataStructures;

import java.util.Arrays;


public class QuickSort {
    //parameters are array to be sorted, beginning index & ending index of array
    //calls partition method to get index of pivot element and recursively partitions left & right side from pivot
    public void quickSort(int[] array, int begin, int end){
        if (begin < end){
            int partitionIndex = partition(array, begin, end);
            
            quickSort(array, begin, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }
    
    //returns index of pivot element after all elements less than or equal to it are put to the left of it
    //in this case we choose pivot to always be last element (many ways we can choose a pivot element)
    public int partition(int[] array, int begin, int end){
        int pivot = array[end];
        int i = begin - 1;
        
        //checks if element is less than pivot and swaps it to the left of array
        for (int j = begin; j < end; j++){
            if (array[j] <= pivot){
                i++;
                
                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }
        
        //finally move the pivot element to its correct index
        int swapTemp = array[i+1];
        array[i+1] = array[end];
        array[end] = swapTemp;
        //return this index
        return i + 1;
    }
    
    //Complexity of O(nlogn)
    public static void main(String[] args){
        QuickSort q = new QuickSort();
        int[] test = {4, 6, 8, 10, 19, 34, 25, 89, 34, 90, 103, 42};
        q.quickSort(test, 0, 11);
        System.out.println(Arrays.toString(test));
    }
    
}
