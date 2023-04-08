import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i = 0 ; i < n ; i++) { // 가로 길
            int len = 0;
            int lastFloor = grid[i][0];
            Boolean[] slope = new Boolean[n];
            Arrays.fill(slope, false);

            int cnt = 0;
            for(int j = 0 ; j < n ; j++){
                if(lastFloor < grid[i][j]) { // 오르막 경사가 생길 경우

                    if(lastFloor + 1 < grid[i][j]){  // 2칸 이상 차이날 경우
                        len = 0;
                        break;
                    }

                    if(len < l) { // 경사로를 놓지 못는 좁은 길
                        len = 0;
                        break;
                    }

                    if(len >= l){ // 경사로를 놓는다. 

                        boolean canDo = true;
                        for(int k = 1 ; k <= l ; k++){
                            if(slope[j - k]) { // 이미 경사로가 놓여있을 경우 (겹칠 경우)
                                canDo = false;
                                break;
                            }
                        }

                        if(canDo) { // 경사로를 놓을 수 있는 경우
                            for(int k = 1 ; k <= l ; k++){
                                slope[j - k] = true; 
                            }
                            len = 0;
                        } else {
                            len = 0;
                            break;
                        }
                    }

                } else if(lastFloor > grid[i][j]) { // 내리막 경사가 생길 경우
                    if(lastFloor - 1 > grid[i][j]) { // 2칸 이상 차이날 경우
                        len = 0;
                        break;
                    }

                    boolean canDo = true;
                    for(int k = 0 ; k < l ; k++){
                        if(n <= j + k) {
                            canDo = false;
                            break;
                        }

                        if(slope[j + k] || grid[i][j] != grid[i][j + k]) { // 이미 경사로가 놓여있을 경우 (겹칠 경우) 또는 놓지 못하는 좁은 길일 경우
                            canDo = false;
                            break;
                        }
                    }

                    if(canDo) { // 경사로를 놓을 수 있는 경우
                        for(int k = 0 ; k < l ; k++){
                            slope[j + k] = true; 
                        }
                        len = 0;
                    } else {
                        len = 0;
                        break;
                    }
                }

                len++;
                cnt++;
                lastFloor = grid[i][j];
            }
            if(cnt == n) {
                answer += 1; 
            }
        }

        for(int j = 0 ; j < n ; j++) { // 세로 길
            int len = 0;
            int lastFloor = grid[0][j];
            Boolean[] slope = new Boolean[n];
            Arrays.fill(slope, false);

            int cnt = 0;
            for(int i = 0 ; i < n ; i++){
                if(lastFloor < grid[i][j]) { // 오르막 경사가 생길 경우
                    if(lastFloor + 1 < grid[i][j]){  // 2칸 이상 차이날 경우
                        len = 0;
                        break;
                    }

                    if(len < l) { // 경사로를 놓지 못는 좁은 길
                        len = 0;
                        break;
                    }

                    if(len >= l){ // 경사로를 놓는다. 
                        boolean canDo = true;
                        for(int k = 1 ; k <= l ; k++){
                            if(slope[i - k]) { // 이미 경사로가 놓여있을 경우 (겹칠 경우)
                                canDo = false;
                                break;
                            }
                        }

                        if(canDo) { // 경사로를 놓을 수 있는 경우
                            for(int k = 1 ; k <= l ; k++){
                                slope[i - k] = true; 
                            }
                            len = 0;
                        } else {
                            len = 0;
                            break;
                        }
                    }

                } else if(lastFloor > grid[i][j]) { // 내리막 경사가 생길 경우
                    if(lastFloor - 1 > grid[i][j]){ // 2칸 이상 차이날 경우
                        len = 0;
                        break;
                    }

                    boolean canDo = true;
                    for(int k = 0 ; k < l ; k++){
                        if(n <= i + k) {
                            canDo = false;
                            break;
                        }

                        if(slope[i + k] || grid[i][j] != grid[i + k][j]) { // 이미 경사로가 놓여있을 경우 (겹칠 경우) 또는 놓지 못하는 좁은 길일 경우
                            canDo = false;
                            break;
                        }
                    }

                    if(canDo) { // 경사로를 놓을 수 있는 경우
                        for(int k = 0 ; k < l ; k++){
                            slope[i + k] = true; 
                        }
                        len = 0;
                    } else {
                        len = 0;
                        break;
                    }    
                }

                len++;
                cnt++;
                lastFloor = grid[i][j];
            }
            if(cnt == n) {
                answer += 1; 
            }
        }


        System.out.println(answer);
    }
}
