import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = n;

        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);

                if (!stack.isEmpty()) {
                    if (stack.peek() == ch) {
                        stack.pop();
                    }
                }

                stack.push(ch);

            }

            String str2 = "";
            while(!stack.isEmpty()){

                char ch = stack.pop();

                if(str2.contains(String.valueOf(ch))){
                    answer--;
                    break;
                }
                str2 += ch;
            }
        }
        System.out.println(answer);

    }
}
