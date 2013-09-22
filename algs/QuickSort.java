/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

import java.util.Arrays;

/**
 * 
 * @author rob
 */
public class QuickSort{
    

    public static void main(String[] args){
        int[] x = {2,3,1,8,4,6};
        int [] y = {1,2,3,4,5,6};
        new QuickSort().sort(x);
        System.out.println(Arrays.toString(x));
        
    }
    

	public void sort(int[] arr){
		quicksort(arr, 0, arr.length-1);
	}
	
	private void quicksort(int[] arr,int low, int high){
		int lo = low,hi=high;
		int pivotValue = arr[low+(high-low)/2];
		while(lo<=hi){
			while(arr[lo] < pivotValue)
				lo++;
			while(arr[hi] > pivotValue)
				hi--;
			
			if(lo<=hi){
				swap(arr,lo,hi);
				lo++;hi--;
			}
		}
		if(low<hi)
			quicksort(arr, low, hi);
		if(lo<high)
			quicksort(arr, lo, high);
	}
	
	private void swap(int arr[],int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;		
	}

}
