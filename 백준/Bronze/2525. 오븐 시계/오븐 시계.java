import java.util.Scanner;

 
public class Main {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int A = keyboard.nextInt();
		int B = keyboard.nextInt();
		int C = keyboard.nextInt();
		
		int time = A*60 +B;
		time += C;
		
		A = (time/60)%24;
		B = time%60;
		
		
		System.out.print(A + " " + B);
	}
}