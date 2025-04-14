
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {



    public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[][] arr = new int[10001][4];
		StringBuilder sb = new StringBuilder();

		arr[1][1] = 1;
		arr[2][1] = 1;
		arr[2][2] = 1;
		arr[3][1] = 1;
		arr[3][2] = 1;
		arr[3][3] = 1;

		for(int i=4; i<=10000; i++){
			arr[i][1] = arr[i-1][1];
			arr[i][2] = arr[i-2][1] + arr[i-2][2];
			arr[i][3] = arr[i-3][1] + arr[i-3][2] + arr[i-3][3];
		}

		for(int i=0; i<t; i++){
			int n = Integer.parseInt(br.readLine());
			int sum = 0;
			
			for(int j=1; j<=3; j++){
				sum += arr[n][j];
			}

			sb.append(sum + "\n");

			
		}

		System.out.println(sb);

    }

}
