import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;

        
        for(int i = 0 ; i < t ; i++){
            int n = Integer.parseInt(br.readLine());
            
            for(int j = 3 ; j < n + 1 ; j++){
                dp[j][0] = dp[j-1][0] + dp[j-2][0];
                dp[j][1] = dp[j-1][1] + dp[j-2][1];
            }

            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }
        System.out.println(sb);
    }
}
