import java.util.*;
import java.io.*;

public class Main {

    private static int max = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<Integer>();
        int[] arr;
        int position = n;
        boolean isOn = true;

        if(n >= k){
            System.out.println(n-k);
        }
        else{
            arr = new int[max + 1];

            Arrays.fill(arr, 0);
            q.add(n);

            while(isOn){
                for(int i = 0 ; i < q.size() ; i ++){
                    position = q.remove();
                    if(position == k){
                        isOn = false;
                        break;
                    }
    
                    if(position + 1 < max && arr[position + 1] == 0){
                        q.add(position + 1);
                        arr[position + 1] = arr[position] + 1;
                    }
    
                    if(position - 1 >= 0 && arr[position - 1] == 0){
                        q.add(position - 1);
                        arr[position - 1] = arr[position] + 1;
                    }
    
                    if(position * 2 < max && arr[position * 2] == 0){
                        q.add(position * 2);
                        arr[position * 2] = arr[position] + 1;
                    }
                }
            }
            System.out.println(arr[k]);
        }
    }
}