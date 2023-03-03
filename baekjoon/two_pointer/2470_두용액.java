import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = n - 1;

        int answerLeft = 0;
        int answerRight = n - 1;
        int min = Integer.MAX_VALUE;
        while(left < right) {
            int sum = arr[left] + arr[right];

            if(sum == 0){
                System.out.printf("%d %d\n", arr[left], arr[right]);
                return;
            }

            if(Math.abs(0 - sum) < Math.abs(min)){
                answerLeft = left;
                answerRight = right;
                min = sum;
            }

            //left가 커지는 경우
            if(arr[left] + arr[right] < 0){
                left += 1;
            }
            else { // right가 작아지는 경우
                right -= 1;
            }
        }
        
        System.out.printf("%d %d\n",arr[answerLeft], arr[answerRight]);
        return;
    }
}
