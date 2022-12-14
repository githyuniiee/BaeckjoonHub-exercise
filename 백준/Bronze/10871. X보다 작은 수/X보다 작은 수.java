import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int N = keyboard.nextInt();
		int X = keyboard.nextInt();
		
		int arr[] = new int[N];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = keyboard.nextInt();
			
			if(arr[i]<X) {
				System.out.print(arr[i]+" ");
			}
		}
	}
}
