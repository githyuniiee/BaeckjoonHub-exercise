import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] A = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
             }
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] B = new int[m][k];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j< k; j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] answer = new int[n][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int K = 0; K < m; K++) {
                    answer[i][j] += A[i][K] * B[K][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }







    }
}