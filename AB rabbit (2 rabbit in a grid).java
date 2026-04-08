import java.util.*;
public class Main {
    static int R, C;

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[R][C];
        int[][] A_visited = new int[R][C];
        int[][] B_visited = new int[R][C];

        int B_ctr=Integer.MAX_VALUE;
        int A_ctr=Integer.MAX_VALUE;

        Queue<int[]> q = new LinkedList<>();
        int[] A_pos=new int[4];
        int[] B_pos=new int[4];

        for (int row = 0; row < R; row++) {
            String line = sc.nextLine();
            for (int col = 0; col < C; col++) {
                grid[row][col] = line.charAt(col);
                if (grid[row][col] == 'A' ){
                    A_pos=new int[]{row,col,0,'A'};
                }
                else if(grid[row][col] == 'B') {
                    B_pos=new int[]{row,col,0,'B'};
                }
            }
        }
        q.add(A_pos);
        q.add(B_pos);
        int[] r_dir = {-1, 0, 1, 0};
        int[] c_dir = {0, -1, 0, 1};

        boolean A_found=false;
        boolean B_found=false;

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int x = arr[0], y = arr[1], ctr = arr[2];
            char ch = (char) (arr[3]);

            if (ch == 'A') A_visited[x][y] = 1;
            else if (ch == 'B') B_visited[x][y] = 1;

            for (int i = 0; i < 4; i++) {
                int X = x + r_dir[i], Y = y + c_dir[i];

                if (X >= 0 && X < R && Y >= 0 && Y < C) {
                    if (ch == 'A' && A_visited[X][Y] == 0) {
                        A_visited[X][Y] = 1;
                        if(grid[X][Y] == '#') continue;
                        ctr++;
                        if (grid[X][Y] == 'C') {
                          // Since A is added in Q first, that means B shouldn't have reached the carrot 
                            if(B_visited[X][Y]==0) {
                                A_found=true;
                                A_ctr=ctr;
                            }
                        }
                        else if(!A_found){
                            q.offer(new int[]{X, Y, ctr, 'A'});
                        }
                    }
                    else if(ch=='B' && B_visited[X][Y]==0) {
                        B_visited[X][Y] = 1;
                        if(grid[X][Y] == '#') continue;
                        ctr++;
                        if (grid[X][Y] == 'C') {
                          if((ctr<=A_ctr) ) {
                                B_found=true;
                                B_ctr=ctr;
                            }
                        }
                        else if(!B_found){
                            q.offer(new int[]{X, Y, ctr, 'B'});
                        }
                    }
                }
            }
        }
        System.out.println((A_found?"A": "") + (B_found?"B":""));
    }

}

