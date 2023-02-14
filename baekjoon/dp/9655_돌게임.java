import java.io.*;

public class Main {
    
    static enum Gamer{
        CY, SK
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(Gamer.values()[n % 2]);
        
        /*  Java 8

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(Gamer.values()[n % 2].toString());

            bw.flush();
            bw.close();
            br.close();
        */
    }
}
