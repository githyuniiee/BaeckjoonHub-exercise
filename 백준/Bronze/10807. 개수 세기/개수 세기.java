import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int N = keyboard.nextInt();
		
		int arr[] = new int[N];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = keyboard.nextInt();
		}
		
		int v = keyboard.nextInt();
		int count = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(v == arr[i]) {
				count++;
			}
		}
		System.out.print(count);
		
		
	}
}
