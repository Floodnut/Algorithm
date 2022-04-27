import java.util.*;
import java.io.*;

public class Main {

    static int[][] maze;
    static boolean[][] used;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        Queue<int[]> dq = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        used = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            String line = br.readLine();  
            for(int j = 0 ; j < m ; j++){
                if(line.charAt(j) == '1'){
                    maze[i][j] = 1;
                }else{
                    maze[i][j] = 0;
                }
            }
        }

        int[] position = new int[]{0, 0};
        dq.add(new int[]{0, 0});
        used[0][0] = true;
        
        while(!dq.isEmpty()){
            position = dq.poll();
            
            for(int p = 0 ; p < 4 ; p++){
                int x = dx[p] + position[0];
                int y = dy[p] + position[1];

                if(n > x && x >= 0 && m > y && y >= 0 && maze[x][y] != 0 && !used[x][y]){
                    dq.add(new int[]{x, y});
                    used[x][y] = true;
                    maze[x][y] = maze[position[0]][position[1]] + 1;
                }
            }
        }
        System.out.println(maze[n-1][m-1]);
    }
}