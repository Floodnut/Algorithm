import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = 0;
        int[] arr = new int[n];
        int[] val = new int[n];

        while(st.hasMoreTokens()){
            arr[v] = Integer.parseInt(st.nextToken());
            val[v] = arr[v++];
        }
     
        Arrays.sort(arr);
        Map<Integer, Integer> sort = new HashMap<>();
        int i = 0;
        for(int a : arr){
            if(!sort.containsKey(a)){
                sort.put(a, i++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int vv : val){
            sb.append(sort.get(vv));
            sb.append(" ");
        }

        System.out.println(sb.toString().strip());
    }
}
