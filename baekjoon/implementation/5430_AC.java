import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for(int tc = 0 ; tc < t ; tc++ ){
            char[] method = br.readLine().strip().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String list = br.readLine().strip();
            String[] arr = list.substring(1, list.length()-1).split(",");

            int left = 0;
            int right = arr.length - 1;

            if(list.length() == 2)
                right = -1;

            boolean isLeft = true;
            StringBuilder sb = new StringBuilder();
            for(char op : method){
                if(op == 'D'){
                    if(right < left){
                        sb.append("error");
                        break;
                    }

                    if(isLeft)
                        left += 1;
                    else
                        right -= 1;
                }
                else if(op == 'R'){
                    isLeft = !isLeft;
                }
            }
 
            if(sb.toString().equals("error")){
                answer.append(sb.toString() + "\n");
            }
            else if(isLeft){
                sb.append("[");
                for(int i = left ; i <= right ; i++){
                    sb.append(arr[i]);

                    if(i != right)
                        sb.append(",");
                }
                sb.append("]");
                answer.append(sb.toString() + "\n");
            } else{
                sb.append("[");
                for(int i = right ; i >= left ; i--){
                    sb.append(arr[i]);

                    if(i != left)
                        sb.append(",");
                }
                sb.append("]");
                answer.append(sb.toString() + "\n");
            }
        }

        System.out.println(answer.toString());
    }
}