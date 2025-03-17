import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		StringBuilder sb = new StringBuilder();
		

		

		for(int i=0; i<n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int ans = 0;

			for(int j=0; j<20; j++){

				int num = Integer.parseInt(st.nextToken());

				if(stack.isEmpty()){
					stack.push(num);
				}else{
					if(stack.peek() < num){
						stack.push(num);
					}else{
						while(!stack.isEmpty() && stack.peek() > num){
							stack2.push(stack.pop());
							ans++;
						}

						stack.push(num);

						while(!stack2.isEmpty()){
							stack.push(stack2.pop());
						}
					}
				}
				
			}
			sb.append(c + " " + ans).append("\n");
			stack.clear();
			stack2.clear();
		}

		System.out.println(sb);

		
	}
}
