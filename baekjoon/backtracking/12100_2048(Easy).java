import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static int[][] grid;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n, answer;

    static void shiftLeft() {

        for(int i = 0 ; i < n ; i++){

            int index = 0;
            int lastBlock = 0;

            for(int j = 0; j < n ; j++) {

                if(grid[i][j] != 0 && grid[i][j] == lastBlock) {
                    grid[i][index - 1] = lastBlock * 2;
                    grid[i][j] = 0;
                    lastBlock = 0; 
                } else if(grid[i][j] != 0) {
                    lastBlock = grid[i][j];
                    grid[i][j] = 0;
                    grid[i][index++] = lastBlock;
                }
            }
        }
    }

    static void shiftRight() {
        for(int i = 0 ; i < n ; i++){

            int index = n - 1;
            int lastBlock = 0;

            for(int j = n - 1; j >= 0 ; j--) {

                if(grid[i][j] != 0 && grid[i][j] == lastBlock) {
                    grid[i][index + 1] = lastBlock * 2;
                    grid[i][j] = 0;
                    lastBlock = 0; 
                } else if(grid[i][j] != 0) {
                    lastBlock = grid[i][j];
                    grid[i][j] = 0;
                    grid[i][index--] = lastBlock;
                }
            }
        }
    }

    static void shiftUp() {
        for(int i = 0 ; i < n ; i++) {

            int index = 0;
            int lastBlock = 0;

            for(int j = 0; j < n ; j++) {
                if(grid[j][i] != 0 && grid[j][i] == lastBlock) {
                    grid[index - 1][i] = lastBlock * 2;
                    grid[j][i] = 0;
                    lastBlock = 0; 
                } else if(grid[j][i] != 0) {
                    lastBlock = grid[j][i];
                    grid[j][i] = 0;
                    grid[index++][i] = lastBlock;
                }
            }
        }
    }

    static void shiftDown() {
        for(int i = 0 ; i < n ; i++) {
            int index = n - 1;
            int lastBlock = 0;

            for(int j = n - 1 ; j >= 0 ; j--) {
                if(grid[j][i] != 0 && grid[j][i] == lastBlock) {
                    grid[index + 1][i] = lastBlock * 2;
                    grid[j][i] = 0;
                    lastBlock = 0; 
                } else if(grid[j][i] != 0) {
                    lastBlock = grid[j][i];
                    grid[j][i] = 0;
                    grid[index--][i] = lastBlock;
                }
            }
        }
    }

    static void bt(int count, int max) {
        if(count == 5) {
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    answer = Math.max(answer, grid[i][j]);

            return;
        }

        int[][] preGrid = new int[n][n];
        for(int i = 0; i < n; i++)
            preGrid[i] = grid[i].clone();

        shiftLeft();
        bt(count + 1, max);
        for(int i = 0; i < n; i++)
            grid[i] = preGrid[i].clone();

        shiftRight();
        bt(count + 1, max);
        for(int i = 0; i < n; i++)
            grid[i] = preGrid[i].clone();

        shiftUp();
        bt(count + 1, max);
        for(int i = 0; i < n; i++)
            grid[i] = preGrid[i].clone();

        shiftDown();
        bt(count + 1, max);
        for(int i = 0; i < n; i++)
            grid[i] = preGrid[i].clone();    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int j = 0 ; j < n ; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }

        if(n == 1) {
            System.out.println(grid[0][0]);
        } else {
            bt(0, 0);
            System.out.println(answer);
        }
    }
}
