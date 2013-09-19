/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algs;

/**
 *
 * @author rob
 */
public class LongestCommonSubsequence
{
    static int dp[][];
    public static int LCS(String a,String b)
    {
        int Rows = a.length()+1;
        int Cols = b.length()+1;
        dp = new int[Rows][Cols];
        for(int i = 0;i<=a.length();i++)
        {
            dp[i][0] = 0;
        }
        for(int i = 0;i<=b.length();i++)
        {
            dp[0][i] = 0;
        }

        for(int i = 1; i <=a.length();i++)
        {
            for(int j = 1;j<=b.length();j++)
            {
                if(i==0||j==0)
                {
                    dp[i][j] = 0;
                }
                else if(a.charAt(i-1) == b.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(backTrace(a, b, a.length(), b.length()));
        return dp[a.length()][b.length()];
    }

    public static String backTrace(String a,String b,int i,int j)
    {
        if(i ==0 || j==0)
            return "";
        else if(a.charAt(i-1) == b.charAt(j-1))
            return backTrace(a, b, i-1, j-1) + a.charAt(i-1);
        else
        {
            if(dp[i][j-1] > dp[i-1][j])
                return backTrace(a, b, i, j-1);
            else
                return backTrace(a, b, i-1, j);
        }

    }


    public static void Print(int dp[][])
    {
        for(int i = 0;i<3;i++)
        {
            for(int j = 0;j<3;j++)
            {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }



    public static void main(String [] agrs)
    {
        System.out.println(LCS("abcwf","abcwf"));
    }

}
