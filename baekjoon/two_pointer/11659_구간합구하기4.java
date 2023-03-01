import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n + 1];
        nums[0] = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n ; i++)
            nums[i] = Integer.parseInt(st.nextToken()) + nums[i - 1];

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(nums[b] - nums[a - 1]);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
