/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

import java.util.LinkedList;
import java.util.List;

/**
 * Used to return a list of entries for K choose C.
 * @author rob
 */
public class Comb{

    public static List<String> choose(String in, int c){
        return choose(in,"",c);
    }
    
    public static List<String> choose(String in, String out, int c){
        List<String> list = new LinkedList<String>();
        if(out.length() == c){
            list.add(out);
        }
        else{
            for(int i = 0;i< in.length();i++){
                list.addAll(choose(in.substring(i+1),out+in.charAt(i),c));
            }
        }
        return list;
    }

    public static void main(String [] args){
        System.out.println(choose("abcd",4));
    }
}
