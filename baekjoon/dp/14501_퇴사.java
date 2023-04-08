import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] m = new int[n + 1]; // 날짜 별 누적 최대 수익
        Arrays.fill(m, 0);

        int[] t = new int[n]; // 날짜 별 상담 소요일
        int[] p = new int[n]; // 날짜 별 상담 수익

        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i]= Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < n ; i++) {
            for(int j = i + t[i] ; j <= n ; j++){
                if(m[j] < m[i] + p[i])
                    m[j] = m[i] + p[i];
            }
        }

        System.out.println(m[n]);
    }    
}
