import java.util.Scanner;
public class Main {

	
	public static void main (String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int k = 1;
		int q = 1;
		int r = 2;
		int b = 2;
		int knight = 2;
		int p = 8;
		
		k = k - keyboard.nextInt();
		q = q - keyboard.nextInt();
		r = r - keyboard.nextInt();
		b = b - keyboard.nextInt(); 
		knight = knight - keyboard.nextInt();
		p = p - keyboard.nextInt();
		
		
		System.out.print(k+ " ");
		System.out.print(q+ " ");
		System.out.print(r+ " ");
		System.out.print(b+ " ");
		System.out.print(knight+ " ");
		System.out.print(p+ " ");
	}
	
}
