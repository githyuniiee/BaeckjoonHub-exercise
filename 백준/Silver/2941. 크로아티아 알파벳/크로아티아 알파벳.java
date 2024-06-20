import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = 0;

        String[] alpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String a : alpha) {
            while (str.contains(a)) {
                str = str.replaceFirst(a, "*");
                answer++;
            }
        }


        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '*') {
                answer++;
            }
        }



        System.out.println(answer);

    }
}
