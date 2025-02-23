import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
   static List<Integer>[] list;
    static int[] matched;
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        matched = new int[m+1];
        check = new boolean[m+1];

        for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}

        for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			for(int j=0; j<s; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));	
			}
		}

        
        int cnt = 0;
        for(int i=1; i<=n; i++){
            Arrays.fill(check, false);
            if(dfs(i)) cnt++;
        }

        System.out.println(cnt);

    }

    static boolean dfs(int cow){
        
        for(int num : list[cow]){
            if(!check[num]){
                check[num] = true;

                if(matched[num] == 0 || dfs(matched[num])){
                    matched[num] = cow;
                    return true;
                }
            }
        }

        return false;
    }

}