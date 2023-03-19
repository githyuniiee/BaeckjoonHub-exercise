import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
        arr = new int[N + 1];

        dfs(0);
    }

    public static void dfs(int idx){
        if(idx == M){
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i]+ " ");
            }
            System.out.println();

        }
        for(int i=1; i<=N; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[idx] = i;
                dfs(idx+1);
                visit[i] = false;

            }
        }

    }

}
