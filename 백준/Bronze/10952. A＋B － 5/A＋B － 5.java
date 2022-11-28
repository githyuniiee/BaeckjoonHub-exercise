import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		while(true) {
			int A = keyboard.nextInt();
			int B = keyboard.nextInt();
			
			if(A==0 && B==0) {
				keyboard.close();
				break;
			}
			System.out.println(A+B);
		}
	}

}
