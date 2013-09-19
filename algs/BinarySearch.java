/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

/**
 *
 * @author rob
 */
public class BinarySearch {

    public static boolean binarySearch(int[] input, int element,int lower, int upper)
    {
//        int midPoint = (upper-lower)/2 + offset;
        int midPoint = (upper-lower)/2 + lower;
        int midval = input[midPoint];
        if(input[midPoint] == element)
            return true;
        if(upper==lower)
            return false;
        if((lower) > input.length)
            return false;
        else if(element > input[midPoint]  )
        {
            return binarySearch(input, element, midPoint, upper);
        }
        else
        {
            return binarySearch(input, element, lower, midPoint);
        }
    }


    public static void main(String[] args)
    {
        int [] x = {2,4,6,8,10,12,14,16,18,20};
        System.out.println(binarySearch(x,21, 0, x.length));

    }
}
