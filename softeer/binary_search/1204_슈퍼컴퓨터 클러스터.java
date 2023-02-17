import java.util.*;
import java.io.*;

public class Main{

    static long b;
    static long[] performance;

    static boolean diff(long v){
        long cost = 0;

        for(long p : performance){
            long d = (v - p > 0) ? v - p : 0;

            cost += d * d;

            if(cost > b)
                return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());
        performance = new long[n]; // 각 클러스터의 성능

        int c = 0;
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            long v = Long.parseLong(st.nextToken());
            performance[c++] = v;
        }

        Arrays.sort(performance);

        long left = performance[0];
        long right = performance[n - 1] + (long)Math.sqrt(b);
        long answer = 0;

        while(left <= right){
            long mid = (left + right) / 2;

            if(diff(mid)){
                left = mid + 1;
                answer = mid;
            }
            else{
                right = mid - 1;
            }
        }

        System.out.println(answer);
    } 
}