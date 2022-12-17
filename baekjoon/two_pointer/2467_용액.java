import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /* 전체 용액 수 입력*/
        int n = Integer.parseInt(br.readLine());
        int[] vals = new int[n];

        /* 각 용액 입력 */
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            vals[i] = Integer.parseInt(st.nextToken());
        }


        int s = 0, e = n - 1;
        Integer v1 = vals[s], v2 = vals[e];
        Integer m = v1 + v2;
        if(m < 0) m *= -1;

        while(s < e - 1){
            if(s < e && Math.abs(vals[s]) > Math.abs(vals[e])) s += 1;
            else e -= 1;

            Integer sum = vals[s] + vals[e];
            if(sum < 0) sum *= -1;
            
            if(sum < m){
                m = sum;
                v1 = vals[s];
                v2 = vals[e];
            }
        }

        /* 결과 */
        sb.append(v1.toString());
        sb.append(" ");
        sb.append(v2.toString());       
        System.out.println(sb.toString());
    }
}