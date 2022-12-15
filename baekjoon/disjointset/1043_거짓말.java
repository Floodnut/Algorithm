import java.io.*;
import java.util.*;

public class Main {
    
    /* 부모 */
    private static int[] parent;
    private static int[] party_parent;

    private static LinkedHashSet<Integer> truth;
    private static HashSet<Integer> truth2;

    /* x의 부모 탐색 */
    public static int find(int x){
        if( x != parent[x]){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    /* x, y 병합 */
    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x > y)
            parent[x] = y;
        else
            parent[y] = x;
    }

    public static void main(String[] args) throws Exception{

        /* 입력 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        truth = new LinkedHashSet<Integer>();  // 진실을 아는 사람  
        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int m = Integer.parseInt(st.nextToken()); // 파티 수

        party_parent = new int[m];
        parent = new int[n + 1];
        for(int i = 1 ; i <= n ; i++)
            parent[i] = i;

        /* 진실을 아는 사람의 수와 번호 */
        st = new StringTokenizer(br.readLine());
        int know = Integer.parseInt(st.nextToken());

        if(know == 0){
            System.out.println(m);
            return;
        }

        while(st.hasMoreTokens()){
            truth.add(Integer.parseInt(st.nextToken()));
        }

        /* 파티, 파티에 오는 사람의 수와 번호 */
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());

            int p_n = Integer.parseInt(st.nextToken()); 

            if(p_n == 0){
                party_parent[i] = 0;
            }
            if(p_n == 1){
                party_parent[i] = Integer.parseInt(st.nextToken()); 
            }
            else{
                int[] party = new int[p_n + 1];

                for(int j = 1 ; j <= p_n ; j++){
                    party[j] = Integer.parseInt(st.nextToken()); 
                }

                for(int j = 1 ; j < p_n ; j++){
                    union(party[j], party[j + 1]);
                }

                party_parent[i] = party[1];
            }
        }

        truth2 = new HashSet<>();
        for (Integer it : truth) {
            truth2.add(it);
            truth2.add(find(it));
        }

        /* 결과 */
        int result = 0;
        for(int i = 0 ; i < m; i++){
            if(!truth2.contains(find(party_parent[i]))){
                result += 1;
            }
        }

        System.out.println(result);
        return;
    }
}
