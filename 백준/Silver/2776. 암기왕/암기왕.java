import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // StringBuilder 사용
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            HashSet<Integer> set = new HashSet<>();
            int first = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String[] st = str.split(" ");

            for (int j = 0; j < st.length; j++) {
                set.add(Integer.parseInt(st[j]));
            }

            int second = Integer.parseInt(br.readLine());
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < second; j++) {
                int num = Integer.parseInt(stk.nextToken());
                if (set.contains(num)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.print(sb); 
    }
}
