import java.io.*;
import java.util.StringTokenizer;

public class Main{

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] grid;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                int node = Integer.parseInt(st.nextToken());
                grid[i][j] = node;
            }
        }
        int cX = r;
        int cY = c;
        int answer = 0;
        boolean activated = true;
        while(activated) {
            if(grid[cX][cY] == 0) {
                grid[cX][cY] = 2;
                answer += 1;
            }

            int nX = -1;
            int nY = -1;
            for(int i = 0 ; i < 4 ; i++){
                int tmpX = cX + dx[i];
                int tmpY = cY + dy[i];
                if(0 <= tmpX && tmpX < n && 0 <= tmpY && tmpY < m && grid[tmpX][tmpY] == 0){
                    nX = tmpX;
                    nY = tmpY;
                    break;
                }

            }

            if(nX == -1) {
                int tmpX = cX + dx[(d + 2) % 4];
                int tmpY = cY + dy[(d + 2) % 4];

                if(0 <= tmpX && tmpX < n && 0 <= tmpY && tmpY < m && grid[tmpX][tmpY] != 1){
                    cX = tmpX;
                    cY = tmpY;
                } else {
                    activated = false;
                    break;
                }
            } else {
                d = (d + 3) % 4;
                int tmpX = cX + dx[d];
                int tmpY = cY + dy[d];

                if(0 <= tmpX && tmpX < n && 0 <= tmpY && tmpY < m && grid[tmpX][tmpY] == 0){
                    cX = tmpX;
                    cY = tmpY;
                }
            }
        }

        System.out.println(answer);
    }
}