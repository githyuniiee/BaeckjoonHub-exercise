import java.io.*;
public class Main {

	static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int sum = 0;


		for(int i=0; i<str.length(); i++){
			int num = Integer.parseInt(str.substring(i,i+1));
			sum += num;
		}

		System.out.println(sum);

		
	}



}