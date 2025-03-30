import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static int[] light;
	static int n,m;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		light = new int[m];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<m; i++){
			light[i] = Integer.parseInt(st.nextToken());
		}

		int start = 1;
		int end = n;
		int ans = 0;

		//이분탐색
		while(start <= end){
			int mid = (start + end) / 2;

			if(check(mid)){
				end = mid - 1;
				ans = mid;
			}else{
				start = mid + 1;
			}
		}

		System.out.println(ans);

    }

	static boolean check(int h){
		int prev = 0;

		for(int i=0; i<m; i++){
			if(light[i] - h <= prev){
				prev = light[i] + h;
			}else{
				return false;
			}
			
		}

		return n - prev <= 0;

	}



}
