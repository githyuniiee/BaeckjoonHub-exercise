import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[n+1];
        StringBuilder sb = new StringBuilder();

        arr[0] = true;
        arr[1] = true; //소수 X

        for(int i=2; i*i<= n; i++){
            if(!arr[i]){
                for(int j=i*i; j<=n; j+= i){
                    arr[j] = true;
                }
            }
        }

        for(int i = m; i <= n; i++) {
			if(!arr[i]) sb.append(i).append("\n");
		}
		System.out.println(sb);
    }
}