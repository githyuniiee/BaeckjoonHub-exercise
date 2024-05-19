import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int myArr[];
    static int checkArr[];
    static int checkSecret;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int a = 1;
        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i<n; i++){

            int num = Integer.parseInt(br.readLine());

            if(stack.isEmpty()){
                while(a <= num){
                    stack.push(a);
//                    System.out.println("+");
                    list.add("+");
                    a++;
                }
            }

            if(num == stack.peek()){
                stack.pop();
//                System.out.println("-");
                list.add("-");

            }else{
                if(a<=num) {
                    while (a <= num) {
                        stack.push(a);
//                        System.out.println("+");
                        list.add("+");
                        a++;
                    }
                    stack.pop();
//                    System.out.println("-");
                    list.add("-");
                }else{
                    list.clear();
                   list.add("NO");
                    break;
                }
            }


        }

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }


    }
}
