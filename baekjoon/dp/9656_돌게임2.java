import java.io.*;

public class Main {
    
    static enum Gamer{
        SK, CY
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(Gamer.values()[n % 2]);
    }
}
