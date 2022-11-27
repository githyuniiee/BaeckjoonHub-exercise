import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
		int A = Integer.parseInt(br.readLine());
		br.close();
		
		for(int i=0; i<A; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
	

	}

}
