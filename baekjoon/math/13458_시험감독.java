// 시험감독 13458

import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] students = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        long answer = 0;
        answer += n;

        for(int i = 0 ; i < n ; i++) {
            int ok = students[i] - b;
            if(0 < ok) {
                answer += ((ok / c) + (((ok % c) == 0) ? 0 : 1));
            }
        }

        System.out.println(answer);
    }
}
