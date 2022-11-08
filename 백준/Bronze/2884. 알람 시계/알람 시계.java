import java.util.Scanner;
public class Main {

	
	public static void main (String[] args) {
	Scanner keyboard = new Scanner(System.in);
	
	int H = keyboard.nextInt();
	int M = keyboard.nextInt();
	
	if(0<=M && M<45) {
		H = H-1;
		M = (M+60)-45;
		if(H<0) {
			H = H+24;
		}
		}
	else if(45 <= M && M <= 60) {
		M = M-45;
		if(H<0) {
			H = H+24;
		}
	}
	System.out.print(H + " " + M);

	}
	
}
