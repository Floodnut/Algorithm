import java.io.*;

public class Main {
    
    static enum Gamer{
        CY, SK
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());


        if((int)(n % 2) == 0)
            System.out.println(Gamer.values()[0]);
        else
            System.out.println(Gamer.values()[1]);
    }
}
