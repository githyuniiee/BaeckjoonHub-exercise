import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int a = keyboard.nextInt();
		int b = keyboard.nextInt();
		int c = keyboard.nextInt();
		
		int max;
		
		if(a != b && b != c && a != c) {
			if (a>b) {
				if(c>a) {
					max = c;
				}
				
				else {
					max = a;
				}
			}
			else {
				if(c>b) {
					max = c;
				}
				
				else {
					max = b;
				}
			}
		
		System.out.println(max * 100);
		}
	
	
	else {
		
		if (a == b && a == c) {
			System.out.println(10000 + a * 1000);

		}
		else {
			if(a==b || a==c) {
				System.out.println(1000 + a*100);
			}
			
			else {
				System.out.println(1000 + b * 100);
			}
		}
	}
	
	}
}
