import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return b[1] - a[1];
            }

        });

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int[] j = new int[2];
            j[0] = Integer.parseInt(st.nextToken());
            j[1] = Integer.parseInt(st.nextToken());

            pq.add(j);
        }

        int answer = 0;
        int[] jew = {0, 0};
        while(w > 0){
            if(jew[0] == 0){
                if(pq.isEmpty())
                    break;
                jew = pq.poll();
            }
                
            if(jew[0] < w){
                answer += (jew[1] * jew[0]);
                w -= jew[0];
                jew[0] = 0;
            }
            else{
                answer += (jew[1] * w);
                jew[0] -= w;
                w = 0;
            }
        }
        System.out.println(answer);
    }
}
