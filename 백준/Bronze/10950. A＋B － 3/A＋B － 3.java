import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int T = keyboard.nextInt();
		int A,B;
		int []array = new int[T];
		
		for(int i=0; i<T; i++) {
			A = keyboard.nextInt();
			B = keyboard.nextInt();
			array[i] = A+B;
		}
		
		
		for(int i=0; i<T; i++) {
			System.out.println(array[i]);
		}
		
	}
}
