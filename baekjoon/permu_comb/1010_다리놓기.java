import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < t ; i++){
            int result = 1;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == m){
                System.out.println(result);
                continue;
            }

            int[][] arr = new int[n + 1][m + 1];
            
            for(int j = 0 ; j <= n ; j++){
                for(int k = 0 ; k <= m ; k++){
                    if(j == 0 || k == 0) arr[j][k] = 0;
                    else if(j == 1) arr[j][k] = k;
                    else if(j == k) arr[j][k] = 1;
                    else arr[j][k] = arr[j - 1][k - 1] + arr[j][k - 1];
                }
            }

            System.out.println(arr[n][m]);
        }
    }
}
