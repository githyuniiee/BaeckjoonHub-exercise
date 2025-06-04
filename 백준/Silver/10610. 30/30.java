import java.io.*;
import java.util.Arrays;
import java.util.Collections;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("");


		Arrays.sort(str, Collections.reverseOrder());
		long sum = 0;
		boolean hasZero = false;
		StringBuilder ans = new StringBuilder();

		for(String s : str){
			int digit = Integer.parseInt(s);
			sum += digit;
			if(digit == 0) hasZero = true;
			ans.append(s);
		}

		if(hasZero && sum % 3 == 0){
			System.out.println(ans);
		}else {
			System.out.println(-1);
		}



	}


}