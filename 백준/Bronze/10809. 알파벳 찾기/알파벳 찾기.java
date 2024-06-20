import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];

        for (int i = 0; i < 26; i++) {
            arr[i] = -1;
        }

        String st = br.readLine();

        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (arr[ch - 'a'] == -1) {
                arr[ch-'a'] = i;
            }
        }

        for(int val : arr){
            System.out.print(val + " ");
        }

    }
}
