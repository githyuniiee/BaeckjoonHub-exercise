import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    
    static int n,m;
    static ArrayList<Integer>[] list;
    static boolean[] check;
    static int[] matched;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            list = new ArrayList[m+1];
            check = new boolean[n+1];
            matched = new int[n+1];

            for(int j=1; j<=m; j++){
                list[j] =  new ArrayList<>();
            }

            for(int j=1; j<=m; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                for(int k=a; k<=b; k++){
                    list[j].add(k);
                }
            }

            int count = 0;
            for(int j=1; j<=m; j++){
                Arrays.fill(check, false);
                if(dfs(j)){

                    count++;
                }
            }

            System.out.println(count);            

        }
        
    }

    static boolean dfs(int person){
        for(int book : list[person]){
            if(!check[book]){
                check[book] = true;

                if(matched[book] == 0 || dfs(matched[book])){
                    matched[book] = person;
                    return true;
                }
            }
        }

        return false;
    }



}