import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] operation;
    static int[] nums;
    static int n, total;
    static int mx, mn;

    static void backtracking(int idx, int result) {
        if(idx == nums.length - 1) {

            if(result < mn)
                mn = result;

            if(mx < result)
                mx = result;

            return;
        }
  
        if(0 < operation[0]) { // +
            operation[0] -= 1;
            backtracking(idx + 1, result + nums[idx + 1]);
            operation[0] += 1;
        }

        if(0 < operation[1]) { // -
            operation[1] -= 1;
            backtracking(idx + 1, result - nums[idx + 1]);
            operation[1] += 1;
        }

        if(0 < operation[2]) { // * 
            operation[2] -= 1;
            backtracking(idx + 1, result * nums[idx + 1]);
            operation[2] += 1;
        }

        if(0 < operation[3]) {// /
            operation[3] -= 1;
            backtracking(idx + 1, result / nums[idx + 1]);
            operation[3] += 1;
        }

        return;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        mn = Integer.MAX_VALUE; 
        mx = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        operation = new int[]{0, 0, 0, 0}; // 사칙연산 별 수
        total = n - 1; // 전체 연산 수
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4 ; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, nums[0]);

        System.out.println(mx);
        System.out.println(mn);
    }
}
