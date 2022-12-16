import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
    
        int[][] backpack = new int[n + 1][k + 1];
        int[] ww = new int[n + 1];
        int[] vv = new int[n + 1];

        
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 1이상
            int v = Integer.parseInt(st.nextToken()); // 0이상

            ww[i] = w;
            vv[i] = v;
        }


        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= k ; j++){
                if(ww[i] > j){
                    backpack[i][j] = backpack[i - 1][j];
                }
                else if(backpack[i - 1][j] > backpack[i - 1][j - ww[i]] + vv[i]){
                    backpack[i][j] = backpack[i - 1][j];
                }
                else{
                    backpack[i][j] = backpack[i - 1][j - ww[i]] + vv[i];
                }
            }
        }
        System.out.println(backpack[n][k]);
    }
}
