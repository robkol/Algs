/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author rob
 */
public class RadixSort
{
    private Vector<List<Integer>> arr = new Vector<List<Integer>>();
    int sizeOfInput;

    private void init()
    {
        arr.clear();
        for(int i = 0 ; i < 10;i++)
        {
            List<Integer> temp = new LinkedList<Integer>();
            arr.add(i,temp);
        }
    }

    public RadixSort()
    {
        init();
    }

    private void add(int number,int multiple)
    {
        int x = number%multiple;
        int y = x/(multiple/10);
        arr.get(y).add(number);
    }

    private int[] toArray()
    {
        int[] temp = new int[sizeOfInput];
        int counter = 0;
        for(int i = 0;i < arr.size();i++)
        {
            List<Integer> tempList = arr.get(i);
            for(int j = 0;j<tempList.size();j++)
            {
                temp[counter++] = tempList.get(j);
            }
        }
        return temp;
    }

    public int[] sort(int[] input)
    {
        int n = 10;
        sizeOfInput = input.length;
        for(int k = 0;k<10;k++)
        {
            for(int i = 0;i< input.length;i++)
            {
                add(input[i], n);
            }
            input = toArray();
            init();
            n *= 10;
            System.out.println(Arrays.toString(input));
        }
        return input;
    }

    public static void main(String args[])
    {
        int in[] = {9,8,350,7,3000,5,4,200,3,1,2,100};
        RadixSort radixSort = new RadixSort();
        int out[] = radixSort.sort(in);

        System.out.println(Arrays.toString(out));

    }

}














//public class RadixSort
//{
//    private Vector<List<Integer>> arr = new Vector<List<Integer>>(10);
//
//    int maxMultiple = 8;
//    int n = 1;
//    int N;
//
//    public RadixSort() {
//        for(int i = 0;i< 10;i++)
//        {
//            List<Integer> temp = new LinkedList<Integer>();
//            arr.add(i, temp);
//        }
//    }
//
//    public void AddToBucket(int x,int m,int n)
//    {
//        int x1 = x%m;
//        int x2 = (int)Math.floor(x1/n);
//        List<Integer> bucket = arr.get(x2);
//        bucket.add(x);
//    }
//    public void clear()
//    {
//        arr.clear();
//        for(int i = 0;i< 10;i++)
//        {
//            List<Integer> temp = new LinkedList<Integer>();
//
//            arr.add(i, temp);
//        }
//    }
//
//
//    private int[] outputArr()
//    {
//        int[] output = new int[N];
//        int offset = 0;
//        for(int i = 0;i<10;i++)
//        {
//            List<Integer> bucketArray = arr.get(i);
//            String s = bucketArray.toString();
//
//            for(int j = 0;j<bucketArray.size();j++)
//            {
//                output[offset++] = bucketArray.get(j);
//
//            }
//        }
//        return output;
//
//    }
//
//    private void Print()
//    {
//        for(int i = 0; i < arr.size();i++)
//        {
//            List<Integer> current = arr.get(i);
//            System.out.println("bucket " + i + " - " + current.toString());
//        }
//    }
//
//
//    public int[] RadixSort(int[] input)
//    {
//        N = input.length;
//        int m = 10;
//        int n = 1;
//
//        for(int k = 0;k<maxMultiple;k++)
//        {
//
//            for(int i =0;i<input.length;i++)
//            {
//                AddToBucket(input[i], m,n);
//            }
//            m *= 10;
//            n *= 10;
//            input = outputArr();
//            Print();
//            System.out.println();
//            clear();
//        }
//        return input;
//    }
//
//    public static void main(String args[])
//    {
//        RadixSort radixSort = new RadixSort();
//        int[] input = {200,1200,13,19,6,3,9,2,1,10,11,13,5,4};
//        int[] output = radixSort.RadixSort(input);
//        System.out.println(Arrays.toString(output));
//    }
//}
