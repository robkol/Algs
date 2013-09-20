/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

import java.util.LinkedList;
import java.util.List;

/**
 * Used to return all the permutations of a given string.
 * @author rob
 */
public class perm
{

    public static List<String> perm(String in)
    {
        return perm(in,"",in.length());
    }

    public static List<String> perm(String in, String out, int length)
    {
        List<String> list = new LinkedList<String>();
        if(out.length() ==length)
        {
            list.add(out);
        }
        else
        {
            for(int i = 0; i< in.length();i++)
            {
                String rest;
                if(i==0)
                    rest = in.substring(1);
                else
                    rest = in.substring(0, i) + in.substring(i+1);

                list.addAll(perm(rest, out+in.charAt(i), length));
            }
        }
        return list;
    }

    public static void main(String [] args)
    {
        System.out.println(perm("abc"));
    }
}
