import java.io.*;
import java.util.*;


public class Main{

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		int H = Integer.parseInt(str[0]);
		int W = Integer.parseInt(str[1]);
		int N = Integer.parseInt(str[2]);
		int M = Integer.parseInt(str[3]);

		int f = (H-1) / (N+1) + 1;
		int s = (W-1) / (M+1) + 1;

		System.out.println(f*s);

	}
}




