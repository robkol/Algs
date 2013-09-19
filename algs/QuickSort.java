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
public class QuickSort
{
    public static void sort(int [] arr)
    {
        sort(arr,0,arr.length-1);
    }
    private static void sort(int [] arr,int lo,int hi)
    {
        if((hi-lo)<2)
            return;

        int midpoint = partition(arr, lo, hi);
        sort(arr,lo,midpoint-1);
        sort(arr,midpoint+1,hi);

    }
    private static int partition(int [] arr, int lo, int hi)
    {
        int pivot = arr[lo];
        int high = hi;
        int low = lo+1;

        while(low<high)
        {
            while(low <= high)
            {
                if(arr[low] < pivot)
                    low++;
                else
                    break;
            }

            while(high > low)
            {
                if(arr[high] > pivot)
                    high--;
                else
                    break;
            }

            if(low<high)
            {
                System.out.println(String.format("Swap %s with %s", arr[low],arr[high]));
                //swap
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
            else
            {
                break;
            }
        }
        arr[lo] = arr[low-1];
        arr[low-1] = pivot;
        return low-1;


    }


    public static void main(String[] args)
    {
        int[] x = {2,3,1};
        sort(x);
        System.out.println(Arrays.toString(x));
    }
}
