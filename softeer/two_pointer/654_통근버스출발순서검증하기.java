import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long answer = 0;

        int n = Integer.parseInt(br.readLine());
        int[] v = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = 1;
        v[0] = 0;
        while(st.hasMoreTokens())
            v[a++] = Integer.parseInt(st.nextToken());
        
        long[][] stack = new long[n + 1][n + 1];
        for(int i = 0 ; i <= n ; i++)
            for(int j = 0 ; j <= n ; j++)
                stack[i][j] = 0;

        for(int i = 1 ; i <= n ; i++){
            for(int j = n - 1; j > 0 ; j--){
                if(v[j + 1] < i){
                    stack[i][j] = stack[i][j + 1] + 1;
                }else{
                    stack[i][j] = stack[i][j + 1];
                }
            }
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = i + 1 ; j <= n - 1  ; j++){
                if(v[i] < v[j]) answer += stack[v[i]][j];
            }
        }

        System.out.println(answer);
    }
}