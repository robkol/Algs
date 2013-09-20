/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

/**
 *
 * @author rob
 */
public class Knapsack{
	
    public static int knapsack(int W, int[] wt,int[] val,int n){
        int dp[][] = new int[W+1][n+1];
        for(int i =0;i<=W;i++){
            dp[i][n] = 0;
        }
        for(int i =0;i<=n;i++){
            dp[0][i] = 0;
        }

        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<=W;j++){
                if(j>=wt[i])
                    dp[j][i] = Math.max(dp[j][i+1],
                        val[i] + dp[j-wt[i]][i+1]);
                else
                    dp[j][i] = 0;
            }
        }
        
        return dp[W][0];
    }

    public static void main(String [] args){
        int [] val = {60,100,120};
        int [] wt = {10,20,30};
        int W = 50;

        System.out.println(knapsack(W, wt, val, 3));

    }

}
