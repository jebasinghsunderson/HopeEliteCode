import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();

        int len1=str1.length();
        int len2=str2.length();

        int[][] mat=new int[len1+1][len2+1];

        int max=0;
        List<int[]> list=new ArrayList<>();

        for(int row=1; row<=len1; row++){
            for(int col=1; col<=len2; col++){

                if(str1.charAt(row-1)==str2.charAt(col-1)){
                    mat[row][col]=mat[row-1][col-1]+1;

                    if(max>mat[row][col])continue;
                    else if(max < mat[row][col]){
                        max=mat[row][col];
                        list=new ArrayList<>();
                    }
                    list.add(new int[]{row,col});
                }
            }
        }
        // printing max sub string length
        System.out.println(max);

        while(!list.isEmpty()){
            int[] arr=list.getFirst();
            int x=arr[0];
            int y=arr[1];
            StringBuilder sb=new StringBuilder();
            // building from reverse
            while(y>=0 && mat[x][y]>0) {
                sb.append(str1.charAt(y-1));
                y--;
                x--;
            }
            System.out.println(sb.reverse().toString());
            list.removeFirst();
        }

        printMat(mat);
    }
    // To print and the check the matrix
    private static void printMat(int[][]mat){
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                    System.out.print(mat[i][j]+" ");
                }System.out.println();
            }
    }

}
