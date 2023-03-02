import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        
        if(n == k) {
            System.out.println(Arrays.stream(nums).sum());
            return;
        }

        int window  = 0;
        for(int i = 0 ; i < k ; i++)
            window += nums[i];

        int answer = window;
        for(int i = 1 ; i <= n - k ; i++) {
            window += (nums[i + k - 1] - nums[i - 1]);
            answer = (answer < window) ? window : answer;
        }
        
        System.out.println(answer);
    }
}
