import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n == 1){
            System.out.println(0);
            return;
        }
            
        int[] arr = new int[n + 1];
        
        for(int i = 0 ; i <= n ; i++)
            arr[i] = i;

        arr[1] = 0;

        int cnt = 0;
        for(int i = 2; i <= n ;i++){
            if(arr[i] == 0)
                continue;

            for(int j = i * 2 ; j <= n ; j += i){
                if(arr[j] != 0)
                    cnt ++;
                arr[j] = 0;
            }
        }
        Arrays.sort(arr);

        int left = cnt + 2;
        int right = cnt + 2;

        int sum = arr[left];
        int answer = 0;
        while(left <= n){
            if(sum == n)
                answer += 1;

            if(right == n){
                sum -= arr[left];
                left += 1;
            } else if(right < n){
                if(sum < n) {
                    right += 1;
                    sum += arr[right];
                } else if(sum >= n){
                    sum -= arr[left];
                    left += 1;
                } else if(left == right){
                    right += 1;
                    sum += arr[right];
                } else {
                    sum -= arr[left];
                    left += 1;
                }
            }
        }
        System.out.println(answer);
    }
}
