/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

/**
 *
 * @author rob
 */
public class FloydWarshall
{
    private static int max = 100000;
    int arr[][] = {{max,1,10,max,max,max},//0
                   {max,max,2,max,max,20},//1
                   {max,max,max,3,max,30},//2
                   {max,max,max,max,4,max},//3
                   {max,max,max,max,max,5},//4
                   {max,max,max,max,max,max}//5
                    };

    public void ShortestPath()
    {
        for(int k = 0;k<6;k++)
        {
            for(int i = 0; i<6;i++)
            {
                for(int j = 0;j<6;j++)
                {
                    int x = arr[i][j];
                    int y = arr[i][k];
                    int z = arr[k][j];
                    int z1 = y+z;
                    int val = Math.min(x, (z1));
                    arr[i][j] = val;
                }
            }
        }
    }

    public void Print()
    {
        for(int i = 0; i<6;i++)
            {
                for(int j = 0;j<6;j++)
                {
                    if(arr[i][j] == max)
                    {
                        System.out.print(" 0 ");
                    }
                    else
                    {
                        System.out.print(" " + arr[i][j] + " ");
                    }
                }
                System.out.println();
            }
    }

    public static void main(String args[])
    {
        FloydWarshall floydWarshall = new FloydWarshall();
        floydWarshall.Print();
        System.out.println();
        floydWarshall.ShortestPath();
        floydWarshall.Print();

    }

}
