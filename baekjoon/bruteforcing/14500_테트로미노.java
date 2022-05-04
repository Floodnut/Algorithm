import java.util.*;
import java.io.*;

public class Main{

    public static int[][][] poly = {
        /* 직선 */
        {{0,0},{0,1},{0,2},{0,3}},
        {{0,0},{1,0},{2,0},{3,0}},

        /* 정사각형 */
        {{0,0},{0,1},{1,0},{1,1}},

        /* ㄴ자 */
        {{0,0},{1,0},{2,0},{2,1}},
        {{0,0},{1,0},{0,1},{0,2}},
        {{0,0},{0,1},{1,1},{2,1}},
        {{0,0},{0,1},{0,2},{-1,2}},
        {{0,0},{0,1},{-1,1},{-2,1}},
        {{0,0},{1,0},{1,1},{1,2}},
        {{0,0},{0,1},{1,0},{2,0}},
        {{0,0},{0,1},{0,2},{1,2}},

        /* S자 */
        {{0,0},{-1,0},{-1,1},{-2,1}},
        {{0,0},{0,1},{1,1},{1,2}},
        {{0,0},{1,0},{1,1},{2,1}},
        {{0,0},{0,1},{-1,1},{-1,2}},

        /* T자 */
        {{0,0},{0,1},{0,2},{-1,1}},
        {{0,0},{1,0},{2,0},{1,1}},
        {{0,0},{0,1},{0,2},{1,1}},
        {{0,0},{0,1},{-1,1},{1,1}}
    };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] tetris = new int[n][m];
        
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while(st.hasMoreTokens()){
                tetris[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        int maxValue = 0;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                for(int k = 0 ; k < 19 ; k++){
                    int value = 0;
                    for(int l = 0 ; l < 4 ; l++){
                        int new_i = i + poly[k][l][0];
                        int new_j = j + poly[k][l][1];
                        if(new_i < 0 || new_i >= n || new_j < 0 || new_j >= m){
                            value = 0;
                            break;
                        }
                        value += tetris[new_i][new_j];
                    }
                    maxValue = Math.max(maxValue, value);
                }
            }
        }
        System.out.println(maxValue);
    }
}