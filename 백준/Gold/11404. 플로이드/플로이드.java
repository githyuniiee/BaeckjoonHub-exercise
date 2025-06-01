import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //나라 개수
		int m = Integer.parseInt(br.readLine()); //버스 개수

		int[][] arr = new int[n+1][n+1];

		final int INF = 1_000_000_000;
	for(int i=1; i<=n; i++){
    	for(int j=1; j<=n; j++){
        	if(i != j) arr[i][j] = INF;
    	}
	}


		for(int i=0; i<m; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());

			arr[start][end] = Math.min(arr[start][end], val);
		}


		// 플로이드-워셜 올바른 순서
	for(int k=1; k<=n; k++){
    	for(int i=1; i<=n; i++){
        	for(int j=1; j<=n; j++){
            	if (arr[i][k] != INF && arr[k][j] != INF)
                	arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
        	}
    	}
	}



		for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(arr[i][j] == INF) System.out.print("0 ");
                else System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
    }


}