import java.io.*;
import java.util.*;
import java.lang.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for(int tc = 1 ; tc <= 10 ; tc++){
            int T = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int answer = 0;
            
            int[] arr = new int[T];
            int i = 0;
            while(st.hasMoreTokens()){
                arr[i++] = Integer.parseInt(st.nextToken());
            }

            for(int j = 0 ; j < T; j++){
                int lc = 1;
                int leftmax = 0;
                int rc = 1;
                int rightmax = 0;
                while(lc < 3 && j - lc >= 0){
                    if(arr[j - lc] > arr[j])
                        break;
                    leftmax = Math.max(leftmax, arr[j - lc]);
                    lc++;
                }
                while(rc < 3 && j + rc < T){
                    if(arr[j + rc] > arr[j])
                        break;
                    rightmax = Math.max(rightmax, arr[j + rc]);
                    rc++;
                }
                if(rc == 3 && lc == 3){
                    answer += arr[j] - Math.max(leftmax, rightmax);
                }
            } 

            sb.append("#" + tc + " " + answer + "\n");
        }
        System.out.println(sb.toString());
	}
}