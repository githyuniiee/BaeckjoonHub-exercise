import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		while(keyboard.hasNextInt()) {
		int A = keyboard.nextInt();
		int B = keyboard.nextInt();
		
		System.out.println(A+B);
		
		}
		
		keyboard.close();
		
		
	}
}
