import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n       = Integer.parseInt(br.readLine());
        long[] road  = new long[n+1];
        long[] price = new long[n+1]; 

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int idx = 1;

        while(st.hasMoreTokens()){
            road[idx++] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        idx = 0;
        while(st.hasMoreTokens()){
            price[idx++] = Integer.parseInt(st.nextToken());
        }

        long stdPrice = price[0];
        long cost    = road[1] * price[0];   
        for(int i = 1 ; i < n ; i++){
            if(stdPrice < price[i]){
                cost += stdPrice * road[i+1];
            }
            else{
                stdPrice = price[i];
                cost += stdPrice * road[i+1];
            }
        }
        System.out.println(cost);
    }
}