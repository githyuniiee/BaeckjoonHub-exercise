import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		long coin = 0;
		long money = w;


		for(int i=0; i<n-1; i++){
			if(arr[i] < arr[i+1] && coin == 0){
				coin = money / arr[i];
				money %= arr[i];
			}else if(arr[i] > arr[i+1] && coin > 0){
				money += coin * arr[i];
				coin = 0;
			}
		}


		if(coin > 0){
			money += coin * arr[n-1];
		}

		System.out.println(money);
		


    }

}