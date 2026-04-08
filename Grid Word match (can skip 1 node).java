import java.util.Scanner;

// cur -> index to check next character
// temp -> allowed number of skip

public class Main {
    static String target;
    static int[] c_dir={-1,-1,-1,0,1,1,1,0};
    static int[] r_dir={1,0,-1,-1,-1,0,1,1};
    static int R,C;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        target = sc.nextLine();

        R = sc.nextInt();
        C = sc.nextInt();

        sc.nextLine();
        char[][] grid = new char[R][C];

        for (int row = 0; row < R; row++) {
            String str = sc.nextLine();
            for (int col = 0; col < C; col++) {
                grid[row][col] = str.charAt(col);
            }
        }
        for(int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if(grid[row][col]==target.charAt(0)) {
                    if(dfs(grid,row,col,1,0)){
                        System.out.println("Yes");
                        return;
                    }
                }
                else if(target.length()>1 &&  grid[row][col]==target.charAt(1)){
                    if(dfs(grid,row,col,2,1)){
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }
        System.out.println("No");
    }
    private static boolean dfs(char[][] grid,int row,int col,int cur,int temp) {
        if (cur-1 >= target.length()-1) return true;
        if(temp==2)return false;
        char ch = grid[row][col];

        grid[row][col]='#';

        for (int i = 0; i < 8; i++) {
            int X = row + r_dir[i];
            int Y = col + c_dir[i];
            if (X >= 0 && X < R && Y >= 0 && Y < C && grid[X][Y] != '#') {

                if (grid[X][Y] == target.charAt(cur)) {
                    if (dfs(grid, X, Y, cur + 1, temp)) {
                        return true;
                    }
                }
                else if (temp == 0) {
                    if (dfs(grid, X, Y, cur+1, temp+1)) {
                        return true;
                    }
                }
            }
        }
        grid[row][col] = ch;
        return false;

    }
/* SAMPLE INPUT
tiger
3 3
ige
asr
asd
 */
}
