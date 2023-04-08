/*
    백준
    14499 주사위 굴리기
*/

import java.util.*;
import java.io.*;

public class Main {

    /* 동 서 북 남 : 1 2 3 4 */
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    /* 주사위 */
    
    //   2
    // 4 1 3 -> 6
    //   5

    //   6
    // 4 2 3 -> 5
    //   1

    //   2
    // 1 3 6 -> 4
    //   5

    //   2
    // 6 4 1 -> 3
    //   5

    //   1
    // 4 5 3 -> 2
    //   6

    //   5
    // 4 6 3 -> 1
    //   2
    static int[] dice;

    // 0 1 2 3 4 5
    // 앞 오 바 왼 위 아
    static void moveRight() {
        int tmp = dice[3];
        dice[3] = dice[2];
        dice[2] = dice[1];
        dice[1] = dice[0];
        dice[0] = tmp;
    }

    static void moveLeft() {
        int tmp = dice[1];
        dice[1] = dice[2];
        dice[2] = dice[3];
        dice[3] = dice[0];
        dice[0] = tmp;
    }
    
    static void moveUp() {
        int tmp = dice[5];
        dice[5] = dice[2];
        dice[2] = dice[4];
        dice[4] = dice[0];
        dice[0] = tmp;
    }
    
    static void moveDown() {
        int tmp = dice[4];
        dice[4] = dice[2];
        dice[2] = dice[5];
        dice[5] = dice[0];
        dice[0] = tmp;
    }

    static void move(int direction) {
        if(direction == 1) {
            moveRight();
        } else if (direction == 2) {
            moveLeft();
        } else if (direction == 3) {
            moveUp();
        } else {
            moveDown();
        }
    }

    public static void main(String[] args) throws IOException {
        dice = new int[]{0, 0, 0, 0, 0, 0};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 지도 세로
        int m = Integer.parseInt(st.nextToken()); // 지도 가로
        int x = Integer.parseInt(st.nextToken()); // 주사위 좌표
        int y = Integer.parseInt(st.nextToken()); // 주사위 좌표
        int k = Integer.parseInt(st.nextToken()); // 명령 개수

        int[][] grid = new int[n][m];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        grid[x][y] = 0; // 주사위를 놓은 칸의 수는 항상 0

        // 이동 명령
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder(); 
        for(int i = 0 ; i < k ; i++) {
            int operation = Integer.parseInt(st.nextToken());

            int nx = dx[operation - 1] + x;
            int ny = dy[operation - 1] + y;

            if(nx < 0 || n <= nx || ny < 0 || m <= ny)
                continue;

            move(operation);

            if(grid[nx][ny] == 0) {
                grid[nx][ny] = dice[2];
            } else {
                dice[2] = grid[nx][ny];
                grid[nx][ny] = 0;
            }

            x = nx; y = ny;
            sb.append(dice[0]).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}
