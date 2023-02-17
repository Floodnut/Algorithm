import java.util.*;
import java.io.*;

public class Main {

    static int[] a;

    /* 이분 탐색 */
    static boolean find(int left, int right, int t){
        while(left <= right){
            int mid = (left + right) / 2;

            if(t == a[mid])
                return true;

            if(right - left == 1){
                if(t != a[left] && t != a[right])
                    break;
                return true;
            }

            if(t < a[mid]){
                right = mid;   
            }
            else{
                left = mid;
            }
        }

        return false;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[n];
        for(int i = 0 ; i < n ;)
            a[i++] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(a);

        br.readLine();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int t = Integer.parseInt(st.nextToken());

            if(find(0, n - 1, t))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
