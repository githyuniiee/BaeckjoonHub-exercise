import java.util.Scanner;
public class Main {

	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);

	    int[] arr = new int[10];
	    int count = 0;

	    for ( int i = 0; i < 10; i++ ) {
	      arr[i] = keyboard.nextInt() % 42;
	    }

	    for ( int i = 0; i < 10; i++ ) {
	     int temp = 0;
	      for ( int k = i+1; k < 10; k++ ) {
	        if ( arr[i] == arr[k] ) {
	          temp++;
	        }
	      }
	   
	      if(temp == 0) {
	    	  count++;
	      }
	  }
	    System.out.println(count);
		
	
		
	}
}
