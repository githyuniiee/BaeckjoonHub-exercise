import java.util.Scanner;
public class Main {

	
	public static void main (String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int Grade = keyboard.nextInt();
		
		if(90 <= Grade && Grade <= 100) {
			System.out.println('A');
		}
		else if( 80 <= Grade && Grade < 90)
		{
			System.out.println('B');
		}
		else if(70 <= Grade && Grade < 80)
		{
			System.out.println('C');
		}
		else if(60 <= Grade && Grade < 70)
		{
			System.out.println('D');
		}
		else
			System.out.println('F');
	}
}
