import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] card;
    static int[] arr;
    static boolean[] visited;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        card = new int[n];
        arr = new int[m];
        visited = new boolean[n];
        set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        dfs(0, m);


        for (String a : set) {
            System.out.println(a);
        }

    }

    static void dfs(int depth, int m){

        if(depth == m){
            String temp = "";
            for (int num : arr) {
                temp += num + " ";
            }
            set.add(temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = card[i];
                dfs(depth+1, m);
                visited[i] = false;
            }
        }
    }

}
