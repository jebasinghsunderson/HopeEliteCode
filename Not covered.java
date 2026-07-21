//https://atcoder.jp/contests/abc408/submissions/77716992
//C - Not All Covered 
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] prefix = new int[n+2];
        prefix[0] = 0;
        for(int i=0 ;i<m; i++){
            int l = sc.nextInt(), r = sc.nextInt();
            prefix[l]+=1;
            prefix[r+1]-=1;
        }
        for(int i=1; i<=n; i++){
            prefix[i] += prefix[i-1];
        }
        int min =Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            min = Math.min(min, prefix[i]);
        }
        System.out.println(min);
    }
}

