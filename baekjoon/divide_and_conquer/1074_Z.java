// https://www.acmicpc.net/problem/1074 Z

import java.io.*;
import java.util.StringTokenizer;

class Main{
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        conquer(r, c, n, 0);
        return;
    }

    static void conquer(int r, int c, int n, int layer){

        int size = (int)Math.pow(2, n - 1) * (int)Math.pow(2, n - 1);

        if(n == 0){
            System.out.println(layer);
            return;
        }

        int rr = (int)Math.pow(2, n - 1);
        int cc = (int)Math.pow(2, n - 1);

        if(r < rr && c < cc){
            conquer(r, c, n - 1, layer);
        }
        else if(r < rr && c >= cc){
            conquer(r, c - cc, n - 1, layer + size * 1);
        }
        else if(r >= rr && c < cc){
            conquer(r - rr, c, n - 1, layer + size * 2);
        }
        else{
            conquer(r - rr, c - cc, n - 1, layer + size * 3);
        }

        return;
    }
}