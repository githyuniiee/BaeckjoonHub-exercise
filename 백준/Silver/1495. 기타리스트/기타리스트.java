import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        boolean[][] list = new boolean[n + 1][m + 1]; 
        list[0][s] = true; 
        int answer = -1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            boolean pass = false;
            for (int j = 0; j <= m; j++) {
                if (list[i][j]) {  
                    int first = arr[i] + j;
                    int second = j - arr[i];

                    if (0 <= first && first <= m) {
                        list[i + 1][first] = true;
                        pass = true;
                    }

                    if (0 <= second && second <= m) {
                        list[i + 1][second] = true;
                        pass = true;
                    }
                }
            }


            if (!pass) break;
        }


        for (int i = m; i >= 0; i--) {
            if (list[n][i]) {
                answer = i; 
                break;
            }
        }


        System.out.println(answer);
    }
}
