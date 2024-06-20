import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int left = 0;
        int right = str.length() - 1;
        int answer = 1;

        while (left < right) {

            char ch1 = str.charAt(left);
            char ch2 = str.charAt(right);

            if(ch1 != ch2){
                answer = 0;
                break;
            }else{
                left++;
                right--;
            }
        }

        System.out.println(answer);

    }
}
