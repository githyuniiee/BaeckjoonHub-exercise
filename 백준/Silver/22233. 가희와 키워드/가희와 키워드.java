import java.io.*;
import java.util.*;

public class Main {

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();

        for(int i=0; i<n; i++){
            String str = br.readLine();
            set.add(str);
        }
        
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++){

            String[] keyword = br.readLine().split(",");

            for(int k=0; k<keyword.length; k++){
                if(set.contains(keyword[k])){
                    set.remove(keyword[k]);
                }
            }

            sb.append(set.size() + "\n");

            
        }

        System.out.println(sb);

    }

   
}