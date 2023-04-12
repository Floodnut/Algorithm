// 백준 1600 말이 되고픈 원숭이
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    // 북동부터 시계방향으로
    static int[] horseDx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] horseDy = {-2, -1, 1, 2, 2, 1, -1, -2};

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    static class Monkey {
        int x;
        int y;
        int horseJump;
        int moveCnt;

        public Monkey(int x, int y, int horseJump, int moveCnt) {
            this.x = x;
            this.y = y;
            this.horseJump = horseJump;
            this.moveCnt = moveCnt;
        }
    }

    static class Grid {
        int road;
        int moveCnt;

        public Grid(int road, int moveCnt) {
            this.road = road;
            this.moveCnt = moveCnt;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        Grid[][] g = new Grid[h][w];
        boolean[][][] visited = new boolean[h][w][k + 1];
        for(int i = 0; i < h ; i++) {
            st = new StringTokenizer(br.readLine()); 

            for(int j = 0 ; j < w ; j++) {
                g[i][j] = new Grid(Integer.parseInt(st.nextToken()), Integer.MAX_VALUE);
                for(int l = 0 ; l <= k ; l++ ){
                    visited[i][j][l] = false;
                }
            }
        }
        
        Queue<Monkey> q = new LinkedList<>();
        q.add(new Monkey(0, 0, 0, 0));
        g[0][0].moveCnt = 0;
        for(int i = 0 ; i < k ; i++)
            visited[0][0][i] = true;

        int answer = -1;
        while(!q.isEmpty()) {
            Monkey current = q.poll();

            if(current.x == h - 1 && current.y == w - 1) {
                if(answer == -1 || current.moveCnt < answer) {
                    answer = current.moveCnt;
                }
            }

            if(0 < k - current.horseJump) {// 말 점프를 아직 쓸 수 있는 경우
                for(int i = 0 ; i < 8 ; i++) {
                    int nx = current.x + horseDx[i];
                    int ny = current.y + horseDy[i];
                    
                    if(nx < 0 || h <= nx || ny < 0 || w <= ny)
                        continue; 

                    if(g[nx][ny].road == 0 && !visited[nx][ny][current.horseJump + 1]) { // 점프할 칸이 방문한 적이 없는 길일 경우
                        visited[nx][ny][current.horseJump + 1] = true;
                        q.add(new Monkey(nx, ny, current.horseJump + 1, current.moveCnt + 1));
                    }
                }

            } 
            
            if(k - current.horseJump == 0) { // 말 점프를 다 쓴 경우
                for(int i = 0 ; i < 4 ; i++) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];
                    
                    if(nx < 0 || h <= nx || ny < 0 || w <= ny)
                        continue; 

                    if(g[nx][ny].road == 0 && !visited[nx][ny][current.horseJump]) { // 이동할 칸이 방문한 적이 없는 길일 경우
                        visited[nx][ny][current.horseJump] = true;
                        g[nx][ny].moveCnt = current.moveCnt + 1;
                        q.add(new Monkey(nx, ny, current.horseJump, current.moveCnt + 1));
                    } 
                }
            }

            for(int i = 0 ; i < 4 ; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if(nx < 0 || h <= nx || ny < 0 || w <= ny)
                    continue; 

                if(g[nx][ny].road == 0 && !visited[nx][ny][current.horseJump]) { // 이동할 칸이 방문한 적이 없는 길일 경우
                    visited[nx][ny][current.horseJump] = true;
                    g[nx][ny].moveCnt = current.moveCnt + 1;
                    q.add(new Monkey(nx, ny, current.horseJump, current.moveCnt + 1));
                } 
            }
        }

        System.out.println(answer);
    }
}
