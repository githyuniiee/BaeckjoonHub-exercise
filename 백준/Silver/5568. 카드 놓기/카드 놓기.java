import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n,k;
    static String[] card;
    static boolean[] visited;
    static ArrayList<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        card = new String[n];
        visited = new boolean[n];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            card[i] = br.readLine();
        }

        bfs(0, "");
        System.out.println(list.size());

    }

    static void bfs(int depth, String str){
        if(depth == k && !list.contains(str)){
            list.add(str);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                bfs(depth+1, str + card[i]);
                visited[i] = false;
            }
        }
    }

}
