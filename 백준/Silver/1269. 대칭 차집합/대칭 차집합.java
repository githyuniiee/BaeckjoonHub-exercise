import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int b = Integer.parseInt(st.nextToken());
            map.put(b, map.getOrDefault(b, 0) + 1);
        }

        int answer = 0;

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                answer++;
            }

        }

        System.out.println(answer);

    }
}

