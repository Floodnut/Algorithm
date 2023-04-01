import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;
    static int[] galaxy;

    static int find(int c){
        if(c == parent[c])
            return c;
        
        return parent[c] = find(parent[c]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);


        if(a < b){
            parent[b] = a;
            galaxy[a] += galaxy[b];
        } else {
            parent[a] = b;
            galaxy[b] += galaxy[a];
        } 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for(int i = 0 ; i <= n ; i++)
            parent[i] = i;

        galaxy = new int[n + 1];
        for(int i = 1 ; i <= n ; i++)
            galaxy[i] = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(find(x) != find(y))
                union(x, y);

            sb.append(galaxy[Math.min(find(x), find(y))]).append("\n");
        }

        System.out.print(sb.toString());
    }
}