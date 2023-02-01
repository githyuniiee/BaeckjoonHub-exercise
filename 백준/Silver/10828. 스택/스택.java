
import java.util.*;
import java.io.*;


class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());


        for(int i=0; i<N; i++){
            String str = br.readLine();

            if(str.contains("push")){
                String spt[] = str.split(" ");
                stack.push(Integer.parseInt(spt[1]));
            }else if(str.contains("pop")){
                if(stack.empty()){
                    System.out.println(-1 );
                }else{
                    System.out.println(stack.pop());
                }
            }else if(str.contains("pop")) {
                if(stack.empty()) {
                    System.out.println(-1);
                } else System.out.println(stack.pop());
            }else if(str.contains("size")) {
                System.out.println(stack.size());
            }else if(str.contains("empty")) {
                if(stack.empty()) System.out.println(1);
                else System.out.println(0);
            }else if(str.contains("top")) {
                if(stack.empty()) System.out.println(-1);
                else System.out.println(stack.peek());
            }
        }
    }
}