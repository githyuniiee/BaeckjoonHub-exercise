import java.io.*;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		String str = br.readLine();
		int len = str.length();


		boolean tag = false;

		for(int i=0; i<len; i++){
			char ch = str.charAt(i);

			if(ch == '<'){
				tag = true;

				if(!stack.isEmpty()){
					while(!stack.isEmpty()){
						sb.append(stack.pop());
					}
				}

				sb.append(ch);
				continue;
			}

			//'<' 나왔다면
			if(tag){

				if(ch == '>'){
					sb.append(ch);
					tag = false;
				}else{
					sb.append(ch);
				}
				continue;

			}else{
				if(ch == ' '){
					if(!stack.isEmpty()){
						while(!stack.isEmpty()){
							sb.append(stack.pop());
						}
						sb.append(ch);
					}
				}else{
					stack.push(ch);
				}

			}
		}

		if(!stack.isEmpty()){
			while(!stack.isEmpty()){
				sb.append(stack.pop());
			}
		}

		System.out.println(sb);











		
    }



}