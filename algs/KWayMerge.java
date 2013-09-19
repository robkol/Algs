/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rob
 */
public class KWayMerge
{
    public static int[] merge(int[] a,int[] b)
    {
        int []c = new int[a.length+b.length];
        int coffset = 0;
        int aoffset = 0;
        int boffset = 0;
        while (aoffset<a.length && boffset < b.length)
        {
            if(a[aoffset] < b[boffset])
            {
                c[coffset++] = a[aoffset++];
            }
            else
            {
                c[coffset++] = b[boffset++];
            }
        }

        if(aoffset == a.length)
        {
            while(boffset<b.length)
            {
                c[coffset++] = b[boffset++];
            }
        }
        else if(boffset == b.length)
        {
            while(aoffset<a.length)
            {
                c[coffset++] = a[aoffset++];
            }
        }


        return c;
    }

    public static void recursiveMerger(List<Integer[]> l)
    {
        if(l.size() == 0)
        {

        }
    }

    public static void main(String [] args)
    {
        int [] a = {2,4,6,8,10,12,14,16,18};
        int [] b = {1,3,5,7,9};

        List<Integer[]> l = new LinkedList<Integer[]>();


        System.out.println(Arrays.toString(merge(a, b)));
    }
}
