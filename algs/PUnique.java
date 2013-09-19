/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author rob
 */
public class PUnique
{
    public static void main(String args[])
    {
        //uncomment to run tests
//        test_uniqueElements();

        //uncomment to run sample cases
//        runSamples();
        

    }

    public static void runSamples()
    {
        //The following outputs the P unique random elements from the input string
        //The first tries to get P unique from a null array
        int[] a =null;
        System.out.println(Arrays.toString(returnRandomNonDuplicates(a, 4)));

        //The second tries to get P unique random elements from an array that has less than P unique elements
        int[] b = {1,1,1,1,2,2,2,2,2,3,3,3,3,3};
        System.out.println(Arrays.toString(returnRandomNonDuplicates(b, 4)));

        //The third gets P unique random elements from an array that has more than P unique elements
        int[] c = {1,1,5,6,2,2,2,7,8,3,9,10,3,3};
        System.out.println(Arrays.toString(returnRandomNonDuplicates(c, 4)));

        //The fourth tries to get no P unique random elements, so an empty array
        int[] d = {1,1,5,6,2,2,2,7,8,3,9,10,3,3};
        System.out.println(Arrays.toString(returnRandomNonDuplicates(d, 0)));
    }

    
    private static int[] uniqueElements(int[] input)
    {
        //this method creates a unique set of elements from the input array
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0 ; i< input.length;i++)
        {
            set.add(input[i]);
        }
        int[] output = new int[set.size()];
        Iterator<Integer> itr = set.iterator();
        int offset = 0;
        while(itr.hasNext())
        {
            output[offset++] = itr.next();
        }
        return output;

    }

    private static int[] createRandomArray(int[] input, int N)
    {
        //There is a more efficient way of doing this and that is by replacing the i'th entry with the last
        //entry of the array and decrementing by one
        //for example
        //lets say our input array is {1,2,3,4,5}
        //our random number generator selects the position 1 (2)
        //we would remove number 2 and place 5 in its position
        //resulting in {1,5,3,4}
        //this would save on the N run time of copying input[] into temp.
        
        LinkedList<Integer> temp = new LinkedList<Integer>();
        for(int i = 0; i< input.length;i++)
        {
            temp.add(input[i]);
        }

        int[] output = new int[N];
        Random random = new Random(System.nanoTime());
        for(int i = 0;i<N;i++)
        {
            int selection = random.nextInt(temp.size());
            int item = temp.get(selection);
            temp.remove(selection);
            output[i] = item;
        }
        return output;
    }

    public static int[] returnRandomNonDuplicates(int[] input,int P)
    {
        if(input == null)
            return null;

        int[] uniqueElems = uniqueElements(input);

        //should this function not be able to return P unique elements,
        //I have decided to make the function return the unique elements that is can
        if(uniqueElems.length < P)
            return createRandomArray(uniqueElems, uniqueElems.length);

        int[] output = createRandomArray(uniqueElems,P);
        return output;

    }

    //outputs whether the two arrays are equal or not
    public static void test_uniqueElements()
    {

        int [] input = {1,2,3};
        int [] correct = {1,2,3};
        int [] output = uniqueElements(input);
        System.out.println(Arrays.equals(output,correct) +
                " {1,2,3} = {1,2,3}");

        int [] input2 = {1,1,1,1,1,1,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3};
        int [] correct2 = {1,2,3};
        int [] output2 = uniqueElements(input2);
        System.out.println(Arrays.equals(output2,correct2) +
                " {1,1,1,1,1,1,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3} = " +
                "{1,2,3}");

        int [] input3 = {3,3,3,3,3,3,2,2,2,2,2,1,1,1,1,1,1,1};
        int [] correct3 = {1,2,3};
        int [] output3 = uniqueElements(input3);
        System.out.println(Arrays.equals(output3,correct3) +
                " {3,3,3,3,3,3,2,2,2,2,2,1,1,1,1,1,1,1} = " +
                "{1,2,3}");

        int [] input4 = {};
        int [] correct4 = {};
        int [] output4 = uniqueElements(input4);
        System.out.println(Arrays.equals(output4,correct4) +
                " {} = {}");

        int [] input5 = {1};
        int [] correct5 = {1};
        int [] output5 = uniqueElements(input5);
        System.out.println(Arrays.equals(output5,correct5) +
                " {1} = {1}");

        int [] input6 = {1,2,3};
        int [] correct6 = {1,3};
        int [] output6 = uniqueElements(input6);
        System.out.println(! Arrays.equals(output6,correct6) +
                " {1,2,3} != {1,3}");

        int [] input7 = {1,2,3};
        int [] correct7 = {};
        int [] output7 = uniqueElements(input7);
        System.out.println(! Arrays.equals(output7,correct7) +
                " {1,2,3} != {}");
    }


}
