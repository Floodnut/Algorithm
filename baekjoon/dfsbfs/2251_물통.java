import java.io.*;
import java.util.*;

public class Main {

    static int a;
    static int b;
    static int c;
    static boolean[][] visited;
    static Set<Integer> answer;

    static void dfs(int from, int to, int origin){
        if(visited[from][to])
            return;


        if(from == 0)
            answer.add(origin);

        visited[from][to] = true;

        // a -> b
        if(from + to > b)
            dfs(from + to - b, b, origin);
        else
            dfs(0, from + to, origin);

        // b -> a
        if(from + to > a)
            dfs(a, from + to - a, origin);
        else
            dfs(from + to, 0, origin);

        // a -> c
        if(from + origin > c)
            dfs(from + origin - c, to, c);
        else
            dfs(0, to, from + origin);

        // c -> a
        if(from + origin > a)
            dfs(a, to, from + origin - a);
        else
            dfs(from + origin, to, 0);

        // b -> c
        if(to + origin > c)
            dfs(from, to + origin - c, c);
        else
            dfs(from, 0, to + origin);
        
        // c -> b
        if(to + origin > b)
            dfs(from, b, to + origin - b);
        else
            dfs(from, to + origin, 0);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        answer = new TreeSet<>();

        if(a > b)
            visited = new boolean[201][201];
        else
            visited = new boolean[201][201];

        dfs(0, 0, c);

        StringBuilder sb = new StringBuilder();
        for(Integer i : answer){
            sb.append(i);
            sb.append(" ");
        }

        System.out.println(sb.toString().strip());
    }
}
