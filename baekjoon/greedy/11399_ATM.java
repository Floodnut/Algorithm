import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(sc.nextLine());
        int total = 0;
        int last = 0;

        for(int i = 0 ; i < n ; i++){
            pq.add(sc.nextInt());
        }
        
        while(!pq.isEmpty()){
            total += pq.poll();
            last += total;
        }

        System.out.println(last);
    }
}