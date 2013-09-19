package Algs;

/**
 *
 * @author rob
 */
public class Prime {


	public Prime(){
		super();
	}
	
    /*
     * This method finds prime numbers in a brute force fashion
     *
     */
    public boolean isPrime1(int n )
    {
        for(int i = 2;i<n;i++)
        {
            int rem = n % i;
            if(n % i == 0)
                return false;
        }
        return true;

    }
    /*
     * This method uses an optimisation that I found while reading through top coder tutorials
     *
     */ 

    public boolean isPrime2(int n)
    {
        if(n==1) return true;
        if(n==2) return true;
        if(n%2==0) return false;

        int m = (int)Math.sqrt((int)n);

        for(int i=3;i<=m;i+=2)
            if(n%i==0)
                return false;
        return true;
    }

    public static void main(String args[])
    {

        Prime p = new Prime();
        long start = System.currentTimeMillis();
        int counter = 0;
        for(int i = 1;i<100000;i++)
        {
            if(p.isPrime1(i))
                counter++;
        }
        long end = System.currentTimeMillis();
        //outputs the performance of the brute force method
        System.out.println(counter + " --- " + (end-start) );
        start = System.currentTimeMillis();
        counter=0;
        for(int i = 1;i<100000;i++)
        {
            if(p.isPrime2(i))
                counter++;
        }
        end = System.currentTimeMillis();
        //outputs the performance of the improved method
        System.out.println(counter + " --- " + (end-start) );
    }

}
