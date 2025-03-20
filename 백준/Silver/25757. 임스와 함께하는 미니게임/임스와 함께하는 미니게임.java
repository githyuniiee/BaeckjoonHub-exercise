import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String game = st.nextToken();

		HashSet<String> set = new HashSet<>();

		for(int i=0; i<n; i++){
			String str = br.readLine();
			set.add(str);
		}

		int ans = 0;



		if(game.equals("Y")){
			ans = set.size();
		}else if(game.equals("F")){
			ans = set.size() / 2;
		}else{
			ans = set.size() / 3;
		}

		System.out.println(ans);





    }
}
