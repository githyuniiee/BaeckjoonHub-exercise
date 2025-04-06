import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int s = 0;
		int e = n-1;
		int ans1 = 0;
		int ans2 = 0;
		int min = Integer.MAX_VALUE;


		while(s < e){

			if(min > Math.abs(arr[e]+arr[s])){
				min = Math.abs(arr[e]+arr[s]);
				ans1 = arr[s];
				ans2 = arr[e];
			}

			if(arr[e] + arr[s] < 0){
				s++;
			}else if(arr[e] + arr[s] > 0){
				e--;
			}else{
				ans1 = arr[s];
				ans2 = arr[e];
				break;
			}
		}

		System.out.println(ans1 + " " + ans2);



	
		
    }

}