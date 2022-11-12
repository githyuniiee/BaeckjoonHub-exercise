import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int X = keyboard.nextInt();
		int N = keyboard.nextInt();
		int total = 0;
		
		for(int i=0; i<N; i++) {
			int a = keyboard.nextInt();
			int b = keyboard.nextInt();
			total += a*b;
		}
		
		if(X == total) {
			System.out.println("Yes");
		}
		else
			System.out.println("No");
		
		
		
	}
}
