import java.util.*;
import java.io.*;

public class Main{

    static int[][] square;
    static Integer white;
    static Integer blue;

    static boolean isSquare(int x, int y, int size){

        for(int i = x ; i < x + size ; i++ )
            for(int j = y ; j < y + size ; j++)
                if(square[x][y] != square[i][j])
                    return false;

        return true;
    }

    public static void conquer(int w, int h, int len){

        if(isSquare(w, h, len)){
            if(square[w][h] == 0)
                white += 1;
            else
                blue += 1;
            return;
        }
        
        int half = len / 2;

        conquer(w, h, half);
        conquer(w + half, h, half);
        conquer(w, h + half, half);
        conquer(w + half, h + half, half);

        return;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        square = new int[n][n];
        white = 0;
        blue = 0;

        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ;j++)
                square[i][j] = Integer.parseInt(st.nextToken());
        }

        conquer(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }
}