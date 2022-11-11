import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int N = keyboard.nextInt();
		
		for(int i=1; i<10 ; i++) {
			System.out.println(N + " * " + i + " = " + N*i);
			
		}
	
	}
}
