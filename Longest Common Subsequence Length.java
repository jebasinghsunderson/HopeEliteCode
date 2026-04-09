import java.util.*;
public class Main{
   public static void main(String[] arg) {
       Scanner sc = new Scanner(System.in);
       String str=sc.nextLine();
       String str2=sc.nextLine();
       int len1=str.length();
       int len2=str2.length();
       int [][]dp=new int[len1+1][len2+1];

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(str.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        System.out.println(dp[len1][len2]);
   }
   // print matrix for checking
   private static void printMat(int[][] dp){
       for(int i=0;i<dp.length;i++){
           for(int j=0;j<dp[i].length;j++){
               System.out.print(dp[i][j]+" ");
           }System.out.println();

       }
   }
}
