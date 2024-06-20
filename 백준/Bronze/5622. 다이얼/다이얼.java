import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[11];

        arr[3] = "ABC";
        arr[4] = "DEF";
        arr[5] = "GHI";
        arr[6] = "JKL";
        arr[7] = "MNO";
        arr[8] = "PQRS";
        arr[9] = "TUV";
        arr[10] = "WXYZ";

        String str = br.readLine();
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            for (int j = 3; j < arr.length; j++) {
                String s = arr[j];
                if(s.contains(String.valueOf(ch))){
                    answer += j;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
