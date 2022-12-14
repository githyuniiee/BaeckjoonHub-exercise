import java.util.Scanner;
public class Main {

	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		int[] arr = {keyboard.nextInt(), keyboard.nextInt(), keyboard.nextInt(), 
				keyboard.nextInt(), keyboard.nextInt(), keyboard.nextInt(),
				keyboard.nextInt(), keyboard.nextInt(),keyboard.nextInt()};
		keyboard.close();
		
		int count = 0;
		int max = 0;
		int index = 0;
		
		for(int value : arr) {
			count++;
			
			if(value > max) {
				max = value;
				index = count;
			}
		}
		System.out.print(max + "\n" + index);
		
		
		
		
		
		
	}
}
