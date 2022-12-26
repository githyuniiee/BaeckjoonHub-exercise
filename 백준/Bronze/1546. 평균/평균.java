import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		 
		double arr[] = new double[keyboard.nextInt()];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = keyboard.nextDouble();
		}
	
		
		double sum = 0;
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length; i++) {
			sum += ((arr[i] / arr[arr.length-1]) * 100);
		}
		System.out.print(sum / arr.length);

	}
		
	

}
