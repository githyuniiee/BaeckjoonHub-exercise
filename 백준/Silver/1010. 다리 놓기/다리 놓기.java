import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[][] D;

    public static void main(String[] args) throws IOException {

        D = new long[31][31];
        for (int i = 0; i <= 30; i++) {
            D[i][i] = 1;
            D[i][0] = 1;
            D[i][1] = 1;
        }

        for (int i = 2; i <= 30; i++) {
            for(int j=1; j<i; j++){
                D[i][j] = D[i - 1][j-1] + D[i - 1][j];
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(D[b][a]);
        }
    }

}
