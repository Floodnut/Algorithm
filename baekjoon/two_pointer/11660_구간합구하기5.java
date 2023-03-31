import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] nums = new int[n + 1][n + 1];
        Arrays.fill(nums[0], 0);

        for(int i = 1 ; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0 ; j <= n ; j++) {
                if(j == 0){
                    nums[i][j] = 0;
                }else{
                    nums[i][j] = Integer.parseInt(st.nextToken()) + nums[i - 1][j] + nums[i][j - 1] - nums[i - 1][j - 1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            sb.append(nums[c][d] - nums[a - 1][d] - nums[c][b - 1] + nums[a - 1][b - 1]);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
