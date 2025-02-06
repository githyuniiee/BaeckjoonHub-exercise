import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<n; i++){
			String str = br.readLine();
			Stack<Character> left = new Stack<>();
			Stack<Character> right = new Stack<>();
			
			for(char ch : str.toCharArray()){

				switch(ch){
					case '<':
					if(!left.isEmpty()){
						right.push(left.pop());
					}
					break;

					case '>':
					if(!right.isEmpty()){
						left.push(right.pop());
					}
					break;


					case '-':
					if(!left.isEmpty()){
						left.pop();
					}
					break;

					default:
					left.push(ch);
					break;
				}

			}

			StringBuilder sb = new StringBuilder();
			while(!left.isEmpty()){
				right.push(left.pop());
			}

			while(!right.isEmpty()){
				sb.append(right.pop());
			}


			System.out.println(sb);


		}

		

		
    }

}

