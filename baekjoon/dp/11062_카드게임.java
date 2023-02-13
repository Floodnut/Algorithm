import java.io.*;
import java.util.*;


/*
 * DP + MiniMax(게임 이론)
 * O(n) 풀이 존재.
 */
public class Main{

    static int[] cards;
    static int[][] select;

    static int dfs(boolean turn, int left, int right){

        if(select[left][right] != -1)
            return select[left][right];

        if(left == right){
            if(turn) 
                return select[left][right] = cards[left];
            else 
                return select[left][right] = 0;
        }

        int a = dfs(!turn, left + 1, right);
        int b = dfs(!turn, left, right - 1);

        if(turn)
            return select[left][right] = (a + cards[left] > b + cards[right]) ? a + cards[left] : b + cards[right];
        else
            return select[left][right] = (a < b) ? a : b;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < tc ; i++){
            int n = Integer.parseInt(br.readLine());
            cards = new int[n];
            select = new int[n][n];

            for(int j = 0; j < n; j++)
                for(int k = 0 ; k < n ;k++)
                    select[j][k] = -1;
            

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++)
                cards[j] = Integer.parseInt(st.nextToken());

            System.out.println(dfs(true, 0, n - 1));
        }   
    }
}