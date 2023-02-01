import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        boolean check = false;
        Stack < Character > stack = new Stack < > ();

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                check = true;
            }
            else if (str.charAt(i) == '>') {
                check = false;
                sb.append(str.charAt(i));
                continue;
            }

            if (check == true) {
                sb.append(str.charAt(i));
            }

            else if (check == false) {

                if (str.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                    continue;
                } else {
                    stack.push(str.charAt(i));
                }
            }

            if (i == str.length() - 1) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }

        // 결과문 출력
        System.out.println(sb);
    }
}