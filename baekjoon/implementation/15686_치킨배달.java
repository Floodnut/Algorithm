import java.io.*;
import java.util.*;

public class Main {
    
    static int min = Integer.MAX_VALUE;
    static List<int[]> house;
    static List<int[]> chicken;

    static int calc(int[] a, int[] b){

        int x = a[0] - b[0];
        int y = a[1] - b[1];
        
        if(x < 0) x *= -1;
        if(y < 0) y *= -1;
        
        return x + y;
    }

    static int distance(List<int[]> list){

        int result = 0;
        for(int i = 0 ; i< house.size() ; i++){
            int m = Integer.MAX_VALUE;
            for(int j = 0; j < list.size() ; j++){
                int dis = calc(house.get(i), list.get(j));

                if(m > dis) m = dis;
            }
            result += m;
        }
        
        return result;
    }

    public static void bt(int max, int m, int start, List<int[]> chickenList, boolean[] used){
        if(m > max)
            return;

        for(int i = start; i < chicken.size(); i++){
            if(!used[i]){
                chickenList.add(chicken.get(i));
                used[i] = true;

                bt(max, m + 1, i + 1, chickenList, used);

                int value = distance(chickenList);
                if(value < min) min = value;

                used[i] = false;
                chickenList.remove(chickenList.size() - 1);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) house.add(new int[]{i, j});
                else if(map[i][j] == 2) chicken.add(new int[]{i, j});
            }
        }

        boolean[] used = new boolean[chicken.size()];
        for(int i = 0 ; i < chicken.size() ; i++) used[i] = false;

        bt(m, 1, 0 ,new ArrayList<int[]>(), used);

        System.out.println(min);
    }
}
