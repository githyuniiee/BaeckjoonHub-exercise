import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int n,m;
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int num){
        if(num == m){
            for(int a : arr){
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++){
            if(!visit[i]) {
                visit[i] = true;
                arr[num] = i+1;
                dfs(num+1);
                visit[i] = false;
            }

        }

    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visit = new boolean[n];

        dfs(0);
        System.out.println(sb);




    }
}
