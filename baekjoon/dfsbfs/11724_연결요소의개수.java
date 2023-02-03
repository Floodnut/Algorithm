import java.util.*;
import java.io.*;


public class Main {

    static boolean[][] g;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        g = new boolean[n + 1][n + 1];
        used = new boolean[n + 1];
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            g[u][v] = true;
            g[v][u] = true;

            used[u] = false;
            used[v] = false;
        }

        for(int i = 1 ; i <= n ; i++){
            if(!used[i]){
                dfs(n, i);
                answer += 1;
            }

        }

        System.out.println(answer);
    }

    static void dfs(int n, int x){
        if(used[x]) return;

        used[x] = true;
        for(int i = 1 ; i <= n; i++){
            if(g[x][i]) dfs(n, i);
        }

        return;
    }
}
