import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] total = new int[n][2];
        int[] result;
        int[][] competition;

        for(int i = 0 ; i < n ; i++){
            total[i][0] = 0;
            total[i][1] = i;
        }

        for(int j = 0 ; j < 3 ; j++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            result = new int[n];
            competition = new int[n][2];

            for(int i = 0 ; i < n ; i++){
                competition[i][0] = Integer.parseInt(st.nextToken());
                competition[i][1] = i;
                total[i][0] += competition[i][0];
            }

            Arrays.sort(competition, new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    return b[0] - a[0];
                }
            });

            
            result[0] = competition[0][1];
            for(int i = 1 ; i < n ; i++){
                if(competition[i][0] == competition[i - 1][0])
                    result[competition[i][1]] = result[competition[i - 1][1]];

                else
                    result[competition[i][1]] = i + 1; 
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < n ; i++){
                sb.append((result[i] == 0) ? 1 : result[i]);
                sb.append(" ");
            }
            System.out.println(sb.toString());
        }

        Arrays.sort(total, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return b[0] - a[0];
            }
        });

        result = new int[n];
        competition = new int[n][2];

        result[0] = total[0][1];
        for(int i = 1 ; i < n ; i++){
            if(total[i][0] == total[i - 1][0])
                result[total[i][1]] = result[total[i - 1][1]];

            else
                result[total[i][1]] = i + 1; 
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            sb.append((result[i] == 0) ? 1 : result[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}