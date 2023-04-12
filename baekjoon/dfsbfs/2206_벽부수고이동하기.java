// 백준 2206 벽 부수고 이동하기
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());  
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());  

        int[][] grid = new int[n][m]; 
        int wallCount = 0;
        for(int i = 0; i < n ; i++) {
            String[] a = br.readLine().trim().split("");

            for(int j = 0 ; j < m ; j++) {
                grid[i][j] = Integer.parseInt(a[j]);

                if(grid[i][j] == 1)
                    wallCount++;
            }
        }

        if(wallCount == 0) {
            System.out.println(n + m - 1);
            return;
        }

        // bfs 시작

        int answer = -2;
        int[][] distance = new int[n][m];
        boolean[][][] visited = new boolean[n][m][2];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++) {
                distance[i][j] = Integer.MAX_VALUE;
                visited[i][j][0] =false;
                visited[i][j][1] = false;
            }
        }
        distance[0][0] = 0;
        visited[0][0][0] = true;
        visited[0][0][1] = true; 

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 0});

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int x = node[0];
            int y = node[1];
            int d = node[2];
            int w = node[3];

            for(int k = 0 ; k < 4 ; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                if(nx < 0 || n <= nx || ny < 0 || m <= ny || grid[nx][ny] == 1 && w == 1)
                    continue;
                
                if(grid[nx][ny] == 1 && w == 0 && !visited[nx][ny][1]) { // 벽을 만났을 때 벽을 뚫지 않은 상태라면
                    q.add(new int[]{nx, ny, d + 1, 1});
                    visited[nx][ny][1] = true;
                    distance[nx][ny] = d + 1;
                } else if(grid[nx][ny] == 0 && !visited[nx][ny][w]) {// 방문하지 않은 길을 만난다며
                    q.add(new int[]{nx, ny, d + 1, w}); 
                    visited[nx][ny][w] = true;
                    distance[nx][ny] = d + 1;
                }

                if(nx == n - 1 && ny == m - 1){
                    if(answer == -2 || distance[nx][ny] < answer)
                        answer = distance[nx][ny];
                }
            }
        }              
        
        System.out.println(answer + 1);
    }
}
