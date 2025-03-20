import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            boolean check = true;
            if (str.equals("end")) break;

            // 연속된 같은 문자 검사 (ee, oo 제외)
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == str.charAt(i + 1) &&
                    !(str.charAt(i) == 'e' && str.charAt(i + 1) == 'e') &&
                    !(str.charAt(i) == 'o' && str.charAt(i + 1) == 'o')) {
                    check = false;
                    break;
                }
            }

            if (check) {
                Queue<Integer> q1 = new LinkedList<>(); // 모음
                Queue<Integer> q2 = new LinkedList<>(); // 자음

                for (int i = 0; i < str.length(); i++) {
                    if (isVowel(str.charAt(i))) {
                        q1.add(i);
                    } else {
                        q2.add(i);
                    }
                }

                // 모음이 하나도 없는 경우
                if (q1.isEmpty()) {
                    check = false;
                } else {
                    // 모음이 3개 연속으로 오는지 검사
                    if (checkThreeConsecutive(q1)) {
                        check = false;
                    }
                    // 자음이 3개 연속으로 오는지 검사 (자음이 있는 경우만)
                    if (!q2.isEmpty() && checkThreeConsecutive(q2)) {
                        check = false;
                    }
                }
            }

            result(check, str);
        }

        System.out.println(sb);
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    static boolean checkThreeConsecutive(Queue<Integer> q) {
        if (q.isEmpty()) return false;

        int now = q.poll();
        int sum = 1;

        while (!q.isEmpty()) {
            int next = q.poll();
            if (now + 1 == next) {
                sum++;
                if (sum == 3) return true; // 연속 3개 확인
            } else {
                sum = 1;
            }
            now = next;
        }
        return false;
    }

    static void result(boolean check, String s) {
        if (check) {
            sb.append("<").append(s).append("> is acceptable.\n");
        } else {
            sb.append("<").append(s).append("> is not acceptable.\n");
        }
    }
}
