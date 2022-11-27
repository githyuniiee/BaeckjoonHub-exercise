import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int A = keyboard.nextInt();
		int star=1;
		int space = A-1;

		for(int k=0; k<A; k++) {
		for(int i=0; i<space; i++) {
			System.out.print(" ");
		}
		for(int j=0; j<star; j++) {
			System.out.print("*");
		}
		System.out.println();
		star++;
		space--;
		}
		

	}

}
