import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        int num = 1;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map.put(str, num);
            map2.put(num, str);
            num++;
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            char ch = str.charAt(0);

            if (('A' <= ch && ch <= 'Z')
                    || ('a' <= ch && ch <= 'z')) {

                System.out.println(map.get(str));

            }else{
                int a = Integer.parseInt(str);
                System.out.println(map2.get(a));

            }
        }

    }
}

