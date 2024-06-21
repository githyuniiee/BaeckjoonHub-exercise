import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] origin = new int[n]; //원본배열
        int[] sorted = new int[n]; //정렬 할 배열
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sorted[i] = origin[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        int rank = 0;

        for (int v : sorted) {

            if (!map.containsKey(v)) {
                map.put(v, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int key : origin) {
            int ranking = map.get(key);	// 원본 배열 원소(key)에 대한 value(순위)를 갖고온다.
            sb.append(ranking).append(' ');
        }

        System.out.println(sb);




    }
}

