import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0 ; tc < t ; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == 1){
                sb.append(a);
                sb.append("\n");
                continue;
            }
            int answer = 1;
            for(int i = 0 ; i < b ; i++){
                answer *= a;
                answer %= 10;
            }

            if(answer == 0)
                sb.append(10);
            else
                sb.append(answer);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
