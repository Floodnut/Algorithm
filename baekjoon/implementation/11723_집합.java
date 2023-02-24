import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int[] s = new int[21];
        Arrays.fill(s, -1);
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < m ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String operation = st.nextToken().trim();

            int t;
            if(operation.equals("add")){
                t = Integer.parseInt(st.nextToken());
                s[t] = t;
            }
            else if(operation.equals("remove")){
                t = Integer.parseInt(st.nextToken());
                s[t] = -1;
            }
            else if(operation.equals("check")){
                t = Integer.parseInt(st.nextToken());
                if(s[t] == t)
                    sb.append("1\n");
                else
                    sb.append("0\n");
            }
            else if(operation.equals("toggle")){
                t = Integer.parseInt(st.nextToken());
                if(s[t] == t)
                    s[t] = -1;
                else
                    s[t] = t;    
            }
            else if(operation.equals("all")){
                s = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
            }
            else if(operation.equals("empty")){
                Arrays.fill(s, -1);
            }
        }
        System.out.print(sb.toString());
    }
}
