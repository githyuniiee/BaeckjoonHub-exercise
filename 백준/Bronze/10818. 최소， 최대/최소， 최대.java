import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int N = keyboard.nextInt();
		int arr[] = new int[N];
		
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = keyboard.nextInt();
			
		}
		
		int max = arr[0];
		int min = arr[0];
		
		for(int i=0; i<arr.length; i++) {
			
			if(max >arr[i]) {
				max = arr[i];
			}
			
			if(min <arr[i]) {
				min = arr[i];
			}
			
		}
		System.out.print(max + " " + min);
		
		
		
		
	
	}
}
