import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		Stack<Integer> stack = new Stack<>();

		int now = 1;
		for(int i=0; i<n; i++){
			int num = Integer.parseInt(br.readLine());

			if(stack.isEmpty()){
				for(int j=now; j<=num; j++){
					sb.append("+" + "\n");
					stack.push(j);
				}
				now = num + 1;
			}


			if(stack.peek() == num){
				sb.append("-" + "\n");
				stack.pop();
			}else{
				if(now <= num){
					while(now <= num){
						stack.push(now);
						sb.append("+" + "\n");
						now++;
					}
					stack.pop();
					sb.append("-" + "\n");
				}else{
					sb.setLength(0);
					sb.append("NO");
					break;
				}
			}
			
		}

		System.out.println(sb);

		
    }

}

