import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;  
            
            if (isBalanced(str)) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }

        System.out.print(sb);
    }

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return false;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}
