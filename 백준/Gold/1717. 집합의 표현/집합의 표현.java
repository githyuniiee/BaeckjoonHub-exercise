import java.io.*;
import java.util.*;

public class Main {


    static int[] graph;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = i;
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(num == 0){
                union(a,b);

            }else{
                if(find(a) == find(b)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }

    }

    static int find(int x){
        if(graph[x] != x){
            graph[x] = find(graph[x]);
        }
        return graph[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB){
            graph[rootB] = rootA;
        }
    }
}