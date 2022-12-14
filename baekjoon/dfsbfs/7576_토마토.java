import java.io.*;
import java.util.*;

public class Main {

    static int[][] tomatoes;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> dq = new LinkedList<int[]>();

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        tomatoes = new int[n][m];
        visited = new boolean[n][m];
        int max = 1;

        for(int i = 0 ; i < n ; i++ ){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                char a = st.nextToken().charAt(0);

                if(a == '1'){
                    tomatoes[i][j] = 1;
                    visited[i][j] = true;
                    dq.add(new int[]{i, j});
                }else if(a == '0'){
                    tomatoes[i][j] = 0;
                    visited[i][j] = false;
                }else{
                    tomatoes[i][j] = -1; 
                    visited[i][j] = false;
                }
            }
        }

        while(!dq.isEmpty()){
            int[] position = dq.poll();

            for(int k = 0 ; k < 4 ; k++){
                int x = position[0] + dx[k];
                int y = position[1] + dy[k];

                if(x > -1 && n > x && y > -1 && m > y && tomatoes[x][y] != -1 && !visited[x][y]){
                    dq.add(new int[]{x, y});
                    tomatoes[x][y] = tomatoes[position[0]][position[1]] + 1;
                    visited[x][y] = true;
                }
            }
        }

        for(int i = 0 ; i < n ; i++ ){
            for(int j = 0 ; j < m ; j++){
                if(tomatoes[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                
                if(max < tomatoes[i][j])
                    max = tomatoes[i][j];
            }
        }
        System.out.println(max - 1);
        return;
    }
}
