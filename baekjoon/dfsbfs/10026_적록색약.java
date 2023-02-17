import java.util.*;
import java.io.*;

public class Main {

    final static int[] dx = {0, 0, -1, 1};
    final static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] grid = new char[n][n];
        boolean[][] used = new boolean[n][n];

        for(int i = 0 ; i < n ; i++){
            grid[i] = br.readLine().strip().toCharArray();
            Arrays.fill(used[i], false);
        }
        
        int answer = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ;j++){
                if(!used[i][j]){
                    char base = grid[i][j];
                    answer += 1;
                    Queue<int[]> q = new LinkedList<>();
                    int[] a = new int[2];
                    a[0] = i;
                    a[1] = j; 
                    used[i][j] = true;
                    q.add(a);
                    while(!q.isEmpty()){
                        int[] b = q.poll();
            
                        for(int k = 0 ; k < 4 ; k++){
                            int x = dx[k] + b[0];
                            int y = dy[k] + b[1];
                            
                            if(base == 'B'){
                                if(0 <= x && x < n && 0 <= y && y < n && !used[x][y] && base == grid[x][y]){
                                    int[] c = new int[2];
                                    c[0] = x; c[1] = y;
                                    used[x][y] = true;
                                    q.add(c);
                                }
                            }
                            else{
                                if(0 <= x && x < n && 0 <= y && y < n && !used[x][y] && 'B' != grid[x][y]){
                                    int[] c = new int[2];
                                    c[0] = x; c[1] = y;
                                    used[x][y] = true;
                                    q.add(c);
                                }
                            }
                        }
                    }
                }
            }
        }

        int answer2 = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ;j++){
                char base = grid[i][j];
                
                if(used[i][j]){
                    answer2 += 1;
                    Queue<int[]> q = new LinkedList<>();
                    int[] a = new int[2];
                    a[0] = i;
                    a[1] = j; 
                    used[i][j] = false;
            
                    q.add(a);
                    while(!q.isEmpty()){
                        a = q.poll();
            
                        for(int k = 0 ; k < 4 ; k++){
                            int x = dx[k] + a[0];
                            int y = dy[k] + a[1];
            
                            if(0 <= x && x < n && 0 <= y && y < n && used[x][y] && grid[x][y] == base){
                                int[] b = new int[2];
                                b[0] = x; b[1] = y;
            
                                used[x][y] = false;
                                q.add(b);
                            }
                        }
                    }
                }
            }
        }
        
        System.out.print(answer2);
        System.out.print(" ");
        System.out.println(answer);
    }
}
