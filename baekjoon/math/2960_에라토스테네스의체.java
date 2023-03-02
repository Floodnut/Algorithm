import java.util.StringTokenizer;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] prime = new int[n + 1];

        for(int i = 0 ; i <= n ; i++)
            prime[i] = i;

        int cnt = 0;
        for(int i = 2 ; i <= n; i++) {
            if(prime[i] == 0) 
                continue;

            for(int j = i ; j <= n ; j += i) {
                if(prime[j] == 0)
                    continue;

                prime[j] = 0;
                cnt++;

                if(cnt == k){
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}
