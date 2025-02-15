import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int L,C;
    static String[] arr;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = br.readLine().split(" ");

        Arrays.sort(arr);


        dfs(0,0,0,""); //now, 자음, 모음, 문자

        System.out.println(sb.toString().trim());


    }

    static void dfs(int now, int cnt1, int cnt2, String str){

        if(str.length() == L){
            if(cnt1 >= 1 && cnt2 >= 2){
                sb.append(str + "\n");
            }
            return;
        }

        if(now >= C){
            return;
        }

        int next = now + 1;


        if(arr[now].equals("a")|| arr[now].equals("e")|| arr[now].equals("i")
        || arr[now].equals("o") || arr[now].equals("u")){
            dfs(next, cnt1 + 1, cnt2, str + arr[now]);
        }else{
            dfs(next, cnt1, cnt2+1, str + arr[now]);
        }

        dfs(next, cnt1, cnt2, str);


    }

    
}