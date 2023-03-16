import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc = 0 ; tc < t ; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            LinkedList<Integer[]> docs = new LinkedList<>() ;
            LinkedList<Integer> order = new LinkedList<>() ;
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                Integer[] input = new Integer[]{i, Integer.parseInt(st.nextToken())};
                docs.add(input);
                order.add(input[1]);
            }

            order.sort(Collections.reverseOrder());

            int answer = 0;
            while(!order.isEmpty()){
                int max = order.get(0);
                Integer[] now = docs.get(0);

                if(now[1] < max){
                    docs.add(now);
                    docs.removeFirst();
                    continue;
                }

                answer += 1;
                if(now[0] == m)
                    break;
                
                docs.removeFirst();
                order.removeFirst();
            }
            sb.append(answer);
            sb.append("\n");
        }

        System.out.println(sb.toString());
        return;
    }
}