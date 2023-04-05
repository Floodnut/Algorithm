
import java.util.*;
import java.io.*;

public class Main {

    //0123 : 상우하좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int turnLeft(int direction) {
        return (direction + 3) % 4;
    }

    static int turnRight(int direction) {
        return (direction + 1) % 4;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        for(int i = 0 ; i < n ; i++)
            Arrays.fill(grid[i], 0);

        int k = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < k ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            grid[r][c] = 1; //1은 사과
        }

        List<int[]> q = new ArrayList<>(); 
        int l = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < l ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            
            int[] data;

            if(d == 'L') {
                data = new int[]{x, 0}; // 0은 좌회전
                q.add(data);    
            } else {
                data = new int[]{x, 1}; // 1은 우회전
                q.add(data);   
            }
        }

        ArrayDeque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{0, 0});

        grid[0][0] = 2; // 2는 뱀
        int idx = 0;
        int second = 0;
        int direction = 1; // 방향의 초기 값은 오른쪽(1)
        while(true) {
            int[] headPos = snake.getFirst();
            int nx = headPos[0] + dx[direction];
            int ny = headPos[1] + dy[direction];

            /* 벽이나 뱀에 부딪혔을 때 */
            if(nx < 0 || n <= nx || ny < 0 || n <= ny || grid[nx][ny] == 2) {
                second++;
                break;
            } 

            /* 아직 이동할 수 있다면 */
            snake.addFirst(new int[]{nx, ny});
            if(grid[nx][ny] == 1) { // 사과가 있다면
                grid[nx][ny] = 2;
            } else { // 사과가 없다면
                grid[nx][ny] = 2;
                int[] removedTail = snake.pollLast();
                grid[removedTail[0]][removedTail[1]] = 0;
            }

            second++;
            if(idx < l) {
                int[] change = q.get(idx);
                if(change[0] == second) {
                    if(change[1] == 0)
                        direction = turnLeft(direction);
                    else
                        direction = turnRight(direction);
                    idx++;
                }
            }
        }

        System.out.println(second);
    }
}
