import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /* 인접리스트 초기화 */
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= N; i++){
            adj.add(new ArrayList<Integer>());

        }

        /* 진입 차수 초기화 */
        int[] indegree = new int[N + 1];
        Arrays.fill(indegree, 0);

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            indegree[b]++;
            adj.get(a).add(b);
        }

        /* 위상 정렬 */
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 1 ; i <= N ; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int student = q.poll();
            sb.append(student + " ");
            for(int j : adj.get(student)){
                indegree[j]--;

                if (indegree[j] == 0) {
                    q.offer(j);
                }
            }
        }
        System.out.println(sb.toString());
    }    
}