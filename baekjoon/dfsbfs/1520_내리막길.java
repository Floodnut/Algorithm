import java.util.*;
import java.io.*;

public class Main {

    static int[][] dp;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0 ,0};
    static int m;
    static int n;
    static int[][] grid;

    static int dfs(int x, int y){
        if(x == m && y == n){
            return 1;
        }

        if(dp[x][y] == -1){
            dp[x][y] = 0;

            for(int i = 0 ; i < 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(0 < nx && nx <= m && 0 < ny && ny <= n && grid[nx][ny] < grid[x][y])
                    dp[x][y] += dfs(nx, ny);
            }
        }

        return dp[x][y];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        dp = new int[m + 1][n + 1];
        grid = new int[m + 1][n + 1];
        for(int i = 1 ; i <= m ; i++){
            Arrays.fill(dp[i], -1);
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= n ; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dfs(1,1));
    }
}
