import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int[] d = new int[N + 1];
            for(int j = 1 ; j <= N; j++){
                d[j] = Integer.parseInt(st.nextToken());
            }

            int[] inDegree = new int[N+1];
            Arrays.fill(inDegree, 0);
            
            /* 인접 리스트 초기화 */
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int j = 0 ; j <= N ; j ++){
                adj.add(new ArrayList<Integer>());
            }

            for(int j = 0; j < K ; j++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                inDegree[y]++;
                adj.get(x).add(y);
            }
            
            int w = Integer.parseInt(br.readLine());


            /* 위상 정렬 */
            Queue<Integer> q = new LinkedList<Integer>();
            int[] answer = new int[N + 1];

            for(int j = 1; j <= N ; j++){
                answer[j] = d[j];
                if(inDegree[j] == 0) q.offer(j);
            }

            while(!q.isEmpty()){
                int building = q.poll();

                for(int k : adj.get(building)){
                    answer[k] = (answer[k] > answer[building] + d[k]) ? answer[k] : answer[building] + d[k];
                    inDegree[k]--;

                    if(inDegree[k] == 0) q.offer(k);
                }
            }

            sb.append(answer[w]+"\n");
        }
        System.out.println(sb);
    } 
}