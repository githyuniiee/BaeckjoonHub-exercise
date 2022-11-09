import java.util.Scanner;
public class Main {

	
	public static void main (String[] args) {
	Scanner keyboard = new Scanner(System.in);
	
	int A = keyboard.nextInt();
	int B = keyboard.nextInt();
	int C = keyboard.nextInt();
	
	int min = 60 *A + B;
	min = min + C;
	
	int hour = (min/60) % 24;
	int minute = min%60;
	
	System.out.println(hour + " " + minute);
	
	}
	
}
