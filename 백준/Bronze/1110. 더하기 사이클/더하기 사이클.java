import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int N = keyboard.nextInt();
		int temp = N;
		int count = 0;
		
		while(true) {
			int left = temp/10;
			int right = temp%10;
			temp = (right*10) + ((left + right)%10);
			count++;
			if(N == temp) {
				break;
			}
		}
		
		System.out.print(count);
		
		
		

	}
}
