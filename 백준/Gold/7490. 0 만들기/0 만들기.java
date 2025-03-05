import java.io.*;

public class Main {

    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            n = Integer.parseInt(br.readLine());

            dfs(1,1,0,1,"1");
            sb.append("\n");
            
        }

        System.out.println(sb);

    }

    static void dfs(int idx, int num, int sum, int op, String str){

   

        if(idx == n){
            sum += (num * op);
            if(sum == 0){
                sb.append(str).append("\n");
            }
            return;
        }

        int next = idx + 1;

         //공백
        dfs(next, (num*10) + next,sum, op, str + " " + next);

        //더하기
        dfs(next, next, sum + (num*op), 1, str + "+" + next);
        
        //빼기
        dfs(next, next, sum + (num*op), -1, str + "-" + next);

        

    }

}