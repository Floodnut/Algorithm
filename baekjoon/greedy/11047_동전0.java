import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); 
        int coinSelect = 0;

        int[] coin = new int[10];
        int use = 0;
        
        for(int i = 0; i < n ; i++){
            coin[i] = Integer.parseInt(br.readLine());
            coinSelect += (coin[i] <= k ? 1 : 0);
        }

        while(k > 0){
            if(coinSelect == 0){
                use += k;
                k = 0;
            }
            else if(k >= coin[coinSelect - 1]){
                k -= coin[coinSelect - 1];
                use += 1;
            }
            else{
                coinSelect -= 1;
            }
        }

        System.out.println(use);
    }
}