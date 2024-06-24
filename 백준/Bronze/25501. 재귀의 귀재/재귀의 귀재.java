import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int t;
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            answer = 1;
            String str = br.readLine();

            System.out.print(isPalin(str) + " ");
            System.out.println(recursion(str, 0, str.length()-1));


        }

    }

    static int isPalin(String str) {
        int start = 0;
        int last = str.length()-1;

        while (start < last) {
            if (str.charAt(start) == str.charAt(last)) {
                start++;
                last--;
            }else{
                return 0;
            }
        }

        return 1;
    }

    static int recursion(String str, int l, int r) {

        if(l >= r){
            return answer;
        }

        if (str.charAt(l) != str.charAt(r)) {
            return answer;
        }else{
            answer++;
            return recursion(str, l+1, r-1);
        }
    }
}

