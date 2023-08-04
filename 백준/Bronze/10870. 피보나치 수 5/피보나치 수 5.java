import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {



    public static long recur(int number){

        if (number == 0) return 0;
        if (number == 1) return 1;

        return recur(number - 1) + recur(number - 2);


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(recur(N));

    }
}
