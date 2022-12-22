
import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        LinkedHashMap<Character, Integer> a = new LinkedHashMap<>();
        int max = 0;
        char maxChar = '1';

        for(int i = 0 ; i < str.length() ; i++){
            char c = Character.toUpperCase(str.charAt(i));

            if(a.containsKey(c))
                a.put(c, a.get(c) + 1);
            else
                a.put(c, 1);

            if(a.get(c) + 1 >= (str.length() / 2) + 1 ){
                System.out.println(c);
                return;
            }

            if(max < a.get(c)){
                max = a.get(c);
                maxChar = c;
            }
        }

        for(Character aa : a.keySet()){
            if(aa != maxChar & a.get(aa) == max){
                System.out.println("?");
                return;
            }
        }
        System.out.println(maxChar);
        return;
    }
}
