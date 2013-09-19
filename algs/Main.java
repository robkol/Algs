/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

/**
 *
 * @author rob
 */
public class Main {

    public boolean isPrime(int n)
    {
        if(n==1) return true;
        if(n==2) return false;
        if(n%2==0) return false;
        
        int m = (int)Math.sqrt((int)n);
        for(int i = 3;i<=m;i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
                
    }

    public static void main(String[] args) {
        Main p = new Main();

        long start = System.currentTimeMillis();
        int counter = 0;
        for(int i = 1;i<100000;i++)
        {
            if(p.isPrime(i))
                counter++;
        }
        long end = System.currentTimeMillis();
        System.out.println(counter + " --- " + (end-start) );
    }

}
