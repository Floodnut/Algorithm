import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main{

    public static void main(String[] args) throws Exception{
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 회의 수 */
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        int[][] arr = new int[n][2];

        /* 회의 */
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[i][0] = s;
            arr[i][1] = e;
        }

        /* 정렬 */
        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            else return a[1] - b[1];
        });

        /* 그리디 */
        int last = 0;
        for(int i = 0 ; i < n ; i++){

            if(arr[i][0] < last) continue;

            last = arr[i][1];
            result += 1;
        }

        /* 결과 */
        System.out.println(result);
    }
}
