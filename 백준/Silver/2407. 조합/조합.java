import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BigInteger[][] arr = new BigInteger[101][101];

        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                arr[i][j] = BigInteger.ZERO;
            }
        }

        for (int i = 0; i <= 100; i++) {
            arr[i][0] = BigInteger.ONE;
            arr[i][1] = BigInteger.valueOf(i);
            arr[i][i] = BigInteger.ONE;
        }

        for (int i = 2; i <= 100; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j - 1].add(arr[i - 1][j]);
            }
        }


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.println(arr[n][m]);





    }

}
