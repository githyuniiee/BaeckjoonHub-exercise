import java.io.*;
import java.util.*;


public class Main{

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		int[] alpha = new int[26];
		int max = 0;

		for(int i=0; i<str.length(); i++){
			alpha[str.charAt(i) - 65]++;
		}

	
		int max_val = 0;
		for(int i=0; i<alpha.length; i++){

			if(alpha[i] > max_val){
				max = i;
				max_val = alpha[i];
			}
		}



		int cnt = 0;
		for(int i=0; i<alpha.length; i++){
			if(max_val == alpha[i]){
				cnt++;
			}
		}

		if(cnt > 1){
			System.out.println("?");
		}else{
			int ans = max + 65;
			System.out.println((char)ans);
		}




		

		
	}
}




