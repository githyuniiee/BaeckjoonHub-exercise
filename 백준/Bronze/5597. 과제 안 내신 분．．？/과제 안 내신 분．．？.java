import java.util.Scanner;
import java.util.Arrays;
public class Main {

	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		boolean arr[] = new boolean[31];
		
		
		for(int i=0; i<28; i++) {
			arr[keyboard.nextInt()] = true;
		}
		
		for(int i=1; i<31; i++) {
			if(!arr[i]) {
				System.out.println(i);
			}
		}
		
	}
}
