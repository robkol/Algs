/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

/**
 *
 * @author rob
 */
public class Knapsack
{
    public static int knapsack2(int W, int[] wt, int[] val,int N)
    {
        int[][] dp = new int[N+1][W+1];
        for(int i = 0;i<=W;i++)
        {
            dp[0][i] = 0;
        }
        for(int i = 0;i<=N;i++)
        {
            dp[i][0] = 0;
        }

        for(int i = N-1;i>=0;i--)
        {
            for(int j = 0;j<=W;j++)
            {
                if(wt[i]<=j)
                {
                int noTake = dp[i+1][j];
                int take = val[i] + dp[i+1][j-wt[i]];
                dp[i][j] = Math.max(noTake,
                                    take);
                }
                else
                {
                    dp[i][j] = dp[i+1][j];
                }
            }

        }

        return dp[0][W];
    }


    public static int knapsack(int W, int[] wt,int[] val,int n)
    {
        int dp[][] = new int[W+1][n+1];
        for(int i =0;i<=W;i++)
        {
            dp[i][n] = 0;
        }
        for(int i =0;i<=n;i++)
        {
            dp[0][i] = 0;
        }

        for(int i = n-1;i>=0;i--)
        {
            for(int j = 0;j<=W;j++)
            {
                if(j>=wt[i])
                    dp[j][i] = Math.max(dp[j][i+1],
                        val[i] + dp[j-wt[i]][i+1]);
                else
                    dp[j][i] = 0;
            }
        }
        
        return dp[W][0];
    }

    public static void main(String [] args)
    {
//        int [] val = {10,4,7};
//        int [] wt = {4,2,3};
        int [] val = {60,100,120};
        int [] wt = {10,20,30};
        int W = 50;

        System.out.println(knapsack(W, wt, val, 3)+" " + knapsack2(W, wt, val, 3));

    }

}
