package algs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * 
 * @author rob
 */
public class RadixSort{
    private Vector<List<Integer>> arr = new Vector<List<Integer>>();
    int sizeOfInput;

    private void init(){
        arr.clear();
        for(int i = 0 ; i < 10;i++){
            List<Integer> temp = new LinkedList<Integer>();
            arr.add(i,temp);
        }
    }

    public RadixSort(){
        init();
    }

    private void add(int number,int multiple){
        int x = number%multiple;
        int y = x/(multiple/10);
        arr.get(y).add(number);
    }

    private int[] toArray(){
        int[] temp = new int[sizeOfInput];
        int counter = 0;
        for(int i = 0;i < arr.size();i++){
            List<Integer> tempList = arr.get(i);
            for(int j = 0;j<tempList.size();j++){
                temp[counter++] = tempList.get(j);
            }
        }
        return temp;
    }

    public int[] sort(int[] input){
        int n = 10;
        sizeOfInput = input.length;
        for(int k = 0;k<10;k++){
            for(int i = 0;i< input.length;i++){
                add(input[i], n);
            }
            input = toArray();
            init();
            n *= 10;
        }
        return input;
    }

    public static void main(String args[]){
        int in[] = {9,8,350,7,3000,5,4,200,3,1,2,100};
        RadixSort radixSort = new RadixSort();
        int out[] = radixSort.sort(in);

        System.out.println(Arrays.toString(out));

    }

}

