import java.util.StringTokenizer;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] prime = new int[n + 1];

        for(int i = 2 ; i <= n ; i++)
            prime[i] = i;

        for(int i = 2 ; i <= n; i++){
            if(prime[i] == 0) continue;
            
            for(int j = 2 * i ; j <= n ; j += i)
                prime[j] = 0;
        }

        for(int i = m ; i <= n ;i++){
            if(prime[i] != 0) System.out.println(prime[i]);
        }
        
        return;
    }
}
