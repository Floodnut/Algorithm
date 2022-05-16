import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int min = (a > c) ? c : a;
            int max = (b > d) ? b + 1 : d + 1;
            int count = 0;
            boolean[] arr = new boolean[max];
            Arrays.fill(arr, false);

            for(int i = min ; i < max ; i++){
                arr[i] = (i >= a && i <= b) && (i >= c && i <= d);
                count += (arr[i]) ? 1 : 0;
            }  
            sb.append("#" + test_case +" " + ((count==0) ? 0 : (count-1)) +"\n");
		}
        System.out.println(sb.toString());
	}
}