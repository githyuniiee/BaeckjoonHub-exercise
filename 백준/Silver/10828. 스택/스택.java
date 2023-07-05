
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int length = str.length();
            switch (str){
                case "pop":
                    if(!stack.isEmpty()){
                        System.out.println(stack.pop());
                    }else{
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(stack.empty()){
                        System.out.println("1");
                    }else{
                        System.out.println("0");
                    }
                    break;
                case "top" :
                    if (!stack.empty()) {
                        System.out.println(stack.peek());
                    }else{
                        System.out.println("-1");
                    }
                    break;
                default:
                    String str1 = str.substring(5, str.length());
                    int a = Integer.parseInt(str1);
                    stack.push(a);
                    break;
            }
        }


    }
}