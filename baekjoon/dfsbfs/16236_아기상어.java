import java.util.*;
import java.io.*;

class Main {

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    static int[][] grid;
    static int n;

    static int getDistance(int sx, int sy, int ex, int ey){
        return Math.abs(ey - sy) + Math.abs(ex - sx);
    }

    static LinkedList<int[]> bfs(int[] baby, int size){
        int[][] distance = new int[n][n];
        for(int i = 0 ; i < n ; i++)
            Arrays.fill(distance[i], 0);

        boolean[][] visited = new boolean[n][n];
        for(int i = 0 ; i < n ; i++)
            Arrays.fill(visited[i], false);

        Queue<int[]> queue = new LinkedList<>();
        LinkedList<int[]> list = new LinkedList<>();
        queue.add(baby);
        visited[baby[0]][baby[1]] = true;

        while(!queue.isEmpty()){
            int[] pos = queue.poll();

            for(int i = 0 ; i < 4 ; i++){
                int x = pos[0] + dx[i];
                int y = pos[1] + dy[i];

                if(0 <= x && x < n && 0 <= y && y < n && !visited[x][y]){
                    if(grid[x][y] <= size){
                        int[] tmp = new int[3];
                        tmp[0] = x; tmp[1] = y; tmp[2] = pos[2] + 1;
                        visited[x][y] = true;
                        queue.add(tmp);

                        if(grid[x][y] < size && grid[x][y] != 0)
                            list.add(tmp);
                    }
                }
            }
        }
        Collections.sort(list, new Comparator<int[]>() {
            
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0] && o1[2] == o2[2])
                    return o2[1] - o1[1];

                if(o1[2] == o2[2])
                    return o2[0] - o1[0];

                return o2[2] - o1[2];
            }
        });
        
        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int answer = 0;

        int[] baby = new int[3];
        int size = 2;
        grid = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while(st.hasMoreTokens()){
                int fish = Integer.parseInt(st.nextToken());
                if(fish == 9) {
                    baby[0] = i;
                    baby[1] = j;
                    baby[2] = 0;
                }
                grid[i][j++] = fish;
            }
        }

        int cnt = 0;
        while(true){
            LinkedList<int[]> result = bfs(baby, size);
            if(result.size() == 0)
                break;

            int[] s = result.pollLast();

            answer += s[2];
            grid[s[0]][s[1]] = 0;
            grid[baby[0]][baby[1]] = 0;

            baby[0] = s[0];
            baby[1] = s[1];

            cnt += 1;
            if(cnt == size){
                size += 1;
                cnt = 0;
            }
        }

        System.out.println(answer);
    }
}