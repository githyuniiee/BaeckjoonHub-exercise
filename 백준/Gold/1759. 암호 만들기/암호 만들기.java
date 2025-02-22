import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int l, c;
    static String[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = br.readLine().split(" ");
        Arrays.sort(arr);  

        dfs(0, 0, 0, ""); 
        System.out.println(sb);
    }

    static void dfs(int now, int num1, int num2, String str) {
        if (str.length() == l) {
            if (num1 >= 1 && num2 >= 2) {
                sb.append(str).append("\n");
            }
            return; 
        }

        //조합문제 visited 배열 사용 x 현재 이후로부터 탐색
        for (int i = now; i < c; i++) {  
            if (isVowel(arr[i])) {
                dfs(i + 1, num1 + 1, num2, str + arr[i]);
            } else {
                dfs(i + 1, num1, num2 + 1, str + arr[i]);
            }
        }
    }

    static boolean isVowel(String ch) {
        return "aeiou".contains(ch);
    }
}
