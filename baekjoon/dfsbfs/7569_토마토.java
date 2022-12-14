// 7569_토마토

import java.io.*;
import java.util.*;

public class Main {

    static int[][][] tomatoes;
    static boolean[][][] visited;
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1}; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> dq = new LinkedList<int[]>();

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        tomatoes = new int[h][n][m];
        visited = new boolean[h][n][m];
        int max = 0;

        for(int i = 0 ; i < h ; i++ ){
            for(int j = 0 ; j < n ; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0 ; k < m ; k++){
                    char a = st.nextToken().charAt(0);

                    if(a == '1'){
                        tomatoes[i][j][k] = 1;
                        visited[i][j][k] = true;
                        dq.add(new int[]{i, j, k});
                    }else if(a == '0'){
                        tomatoes[i][j][k] = 0;
                        visited[i][j][k] = false;
                    }else{
                        tomatoes[i][j][k] = -1; 
                        visited[i][j][k] = false;
                    }
                }
            }
        }

        while(!dq.isEmpty()){
            int[] position = dq.poll();

            for(int k = 0 ; k < 6 ; k++){
                int x = position[0] + dx[k];
                int y = position[1] + dy[k];
                int z = position[2] + dz[k];

                if(x > -1 && h > x && y > -1 && n > y && z > -1 && m > z && tomatoes[x][y][z] == 0 && !visited[x][y][z]){
                    dq.add(new int[]{x, y, z});
                    tomatoes[x][y][z] = tomatoes[position[0]][position[1]][position[2]] + 1;
                    visited[x][y][z] = true;
                }
                
            }
        }

        for(int i = 0 ; i < h ; i++ ){
            for(int j = 0 ; j < n ; j++){
                for(int k = 0 ; k < m ; k++){
                    if(tomatoes[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                    
                    if(max < tomatoes[i][j][k])
                        max = tomatoes[i][j][k];
                }
            }
        }
        System.out.println(max - 1);
        return;
    }
}
