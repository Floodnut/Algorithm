import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    static int find(int a){

        if(a != parent[a]){
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
    
    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a > b){
            parent[b] = a;
        }
        else{
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        parent = new int[n+1];

        for(int i = 0; i < n + 1; i++){
            parent[i] = i;
        }

        for(int i = 0; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");

            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

              if (op == 1){
                if(find(a) == find(b)){
                    sb.append("YES\n");
                }
                else{
                    sb.append("NO\n");
                }
            }
            else{
                union(a, b);
            }
        }
        System.out.println(sb.toString());
    }
}