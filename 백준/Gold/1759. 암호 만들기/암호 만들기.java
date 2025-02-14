import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int l,c;
    static String[] alpha;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        alpha = br.readLine().split(" ");
     
        Arrays.sort(alpha);


        dfs(0,0,0,"");
          

        System.out.println(sb.toString().trim());

        
    }

    static void dfs(int count1, int count2, int now, String str){


        if(str.length() == l ){

            if(count1 >=1 && count2 >= 2){
                sb.append(str + "\n");
            }
            return;
        }

        if(now >= c) return;



        if(alpha[now].equals("a") || alpha[now].equals("e") ||
        alpha[now].equals("i") || alpha[now].equals("o") || 
        alpha[now].equals("u")){

            dfs(count1 + 1, count2, now + 1, str + alpha[now]);
            
        }else{
            dfs(count1, count2 + 1, now + 1, str + alpha[now]);
        }

   
        //현재 알파벳 선택 X
        dfs(count1, count2, now + 1, str);


    }
}
