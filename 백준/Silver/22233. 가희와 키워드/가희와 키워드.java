import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            String keyword = br.readLine();
            map.put(keyword, map.getOrDefault(keyword, 0) + 1);
        }

        for(int i=0; i<m; i++){
            String[] word = br.readLine().split(",");

            for(int j=0; j<word.length; j++){
                if(map.containsKey(word[j])){
                    map.put(word[j], map.getOrDefault(word[j], 0) - 1);

                    if(map.get(word[j]) == 0) map.remove(word[j]);
                }
            }

            sb.append(map.size() + "\n");
        }

        System.out.println(sb);
     

    }
}