import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        try{
            PriorityQueue<Integer> q = new PriorityQueue<>(); 
            for(int i = 0 ; i < n ; i++){
                int x = Integer.parseInt(br.readLine());
    
                if(x == 0){
                    Integer v = q.poll();
                    if(v == null)
                        System.out.println(0);
                    else
                        System.out.println(v);
                }
                else
                    q.add(x);
            }
        } catch(NullPointerException e){
        }
        
        return;
    }
    
}
