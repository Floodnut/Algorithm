import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;

class Solution
{

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0 , 0};

	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = Integer.parseInt(br.readLine());
            int[][] grid = new int[n][n]; // 지도
            int[][] road = new int[n][n]; // 경로 최단시간 저장

            for(int i = 0 ; i < n ; i++){
                String[] a = br.readLine().trim().split("");

				for(int j = 0 ; j < n ; j++){
                    grid[i][j] = Integer.parseInt(a[j]);
                    road[i][j] = Integer.MAX_VALUE;
                }
            }

            Queue<int[]> q = new LinkedList<>(); 
            q.add(new int[]{0, 0}); // 시작점 저장
            road[0][0] = 0;
            while(!q.isEmpty()) {
                int[] cur = q.poll();

                for(int i = 0 ; i < 4 ; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];

                    if(nx < 0 || n <= nx || ny < 0 || n <= ny) // 지도 범위를 넘어서면 무시
                        continue;

                    if(road[cur[0]][cur[1]] + grid[nx][ny] < road[nx][ny]) { // 기존 소요시간보다 새롭게 찾은 길의 소요시간이 적으면 (== 더 짧은 길일 경우)
                        road[nx][ny] = road[cur[0]][cur[1]] + grid[nx][ny];
                        q.add(new int[]{nx, ny});
                    }
                }

            }

            sb.append(String.format("#%d %d\n", test_case, road[n - 1][n - 1]));
		}
		System.out.print(sb.toString());
	}
}