/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

import java.util.HashMap;

/**
 * 
 * @author rob
 */
public class BaseConversion2 {

    HashMap<Character,Integer> mapping = new HashMap<Character, Integer>();
    char arr[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

    public BaseConversion2() {
        mapping.put('0', 0);
        mapping.put('1', 1);
        mapping.put('2', 2);
        mapping.put('3', 3);
        mapping.put('4', 4);
        mapping.put('5', 5);
        mapping.put('6', 6);
        mapping.put('7', 7);
        mapping.put('8', 8);
        mapping.put('9', 9);
        mapping.put('A', 10);
        mapping.put('B', 11);
        mapping.put('C', 12);
        mapping.put('D', 13);
        mapping.put('E', 14);
        mapping.put('F', 15);
    }



    public String betweenBases(String input,int b1,int b2)
    {
        return toBase(toDecimal(input, b1), b2);
    }

    private int toDecimal(String input,int b1)
    {
        int multiplier = 1;
        int result = 0;
        for(int i = input.length()-1;i>=0;i--)
        {
            result += mapping.get(input.charAt(i))*multiplier;
            multiplier *= b1;
        }
        return result;
    }

    private String toBase(int decValue, int b2)
    {
        StringBuilder sb = new StringBuilder();
        while(decValue>0)
        {
            sb.append(arr[decValue%b2]);
            decValue /= b2;
        }
        sb.reverse();
        return sb.toString();
    }



    public static void main(String args[])
    {
        BaseConversion2 baseConversion = new BaseConversion2();
        System.out.println(baseConversion.betweenBases("1000011011000100", 2, 16));
    }

}
