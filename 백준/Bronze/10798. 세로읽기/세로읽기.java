import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[5][15];
        int maxLength = 0;

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            maxLength = Math.max(maxLength, str.length());
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] != '\0') {
                    System.out.print(arr[j][i]);
                }
            }
        }
    }
}
