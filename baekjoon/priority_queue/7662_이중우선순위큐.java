import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0 ; t < tc ; t++){
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            
            for(int i = 0 ; i < k ; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                String operator = st.nextToken();
                int operand = Integer.parseInt(st.nextToken());
                
                switch(operator){
                    case "I":
                        treeMap.put(operand, treeMap.getOrDefault(operand, 0) + 1);
                        break;
                    case "D":
                        if(treeMap.isEmpty())
                            break;

                        if(operand < 0){
                            int minKey = treeMap.firstKey();
                            if(treeMap.get(minKey) == 1) 
                                treeMap.remove(minKey);
                            else 
                                treeMap.put(minKey, treeMap.get(minKey) - 1);
                        }
                        else{
                            int maxKey = treeMap.lastKey();
                            if(treeMap.get(maxKey) == 1) 
                                treeMap.remove(maxKey);
                            else 
                                treeMap.put(maxKey, treeMap.get(maxKey) - 1);
                        }
                            
                        break;
                }
            }


            if(treeMap.isEmpty()){
                sb.append("EMPTY\n");
            }
            else{
                sb.append(treeMap.lastKey());
                sb.append(" ");
                sb.append(treeMap.firstKey());
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
