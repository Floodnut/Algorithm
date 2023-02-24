import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        if(r == 0 || n == r){
            System.out.println(1);
            return;
        }

        long answer = fact(n) / (fact(r) * fact(n - r)) ;

        System.out.println(answer);
    }
}
