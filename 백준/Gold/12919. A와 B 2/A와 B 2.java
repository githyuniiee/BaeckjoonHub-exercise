import java.io.*;

public class Main {

    static String s, t;
    static boolean answer = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();

        dfs(new StringBuilder(t));

        System.out.println(answer ? 1 : 0);
    }

    static void dfs(StringBuilder sb) {
        // 종료 조건: 목표 문자열보다 길이가 짧아지면 탐색 중단
        if (sb.length() < s.length()) return;
        
        // 목표 문자열과 같으면 성공
        if (sb.toString().equals(s)) {
            answer = true;
            return;
        }

        // A 제거
        if (sb.charAt(sb.length() - 1) == 'A') {
            sb.deleteCharAt(sb.length() - 1);
            dfs(sb);
            sb.append('A');  // 백트래킹 (원상 복구)
        }

        // B 제거 후 뒤집기
        if (sb.charAt(0) == 'B') {
            sb.deleteCharAt(0);
            sb.reverse();
            dfs(sb);
            sb.reverse();
            sb.insert(0, 'B');  // 백트래킹 (원상 복구)
        }
    }
}
