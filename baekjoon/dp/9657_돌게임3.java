import java.io.*;

public class Main {

    static enum Gamer{
        SK, CY
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n % 7 == 0 || n % 7 == 2){
            System.out.println(Gamer.values()[1]);
            return;
        }

        System.out.println(Gamer.values()[0]);
        return;  
    }
}
