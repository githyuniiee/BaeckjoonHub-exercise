import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static char[] arr;
	static ArrayList<String> list = new ArrayList<>();
	static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new char[n];
		visit = new boolean[10];
	

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<n; i++){
			arr[i] = st.nextToken().charAt(0);
		}

		for (int i = 0; i < 10; i++) {

			visit[i] = true;
			dfs(i, 0, i+"");
			visit[i] = false;
		}

		Collections.sort(list);

		System.out.println(list.get(list.size() - 1));
		System.out.println(list.get(0));


	}

	static void dfs(int now, int count, String str){
		if(count == n){
			list.add(str);
			return;
		}


		for(int i=0; i<10; i++){
			if(!visit[i]){
				if((arr[count] == '<' && now < i) || (arr[count] == '>' && now > i)){
					visit[i] = true;
					dfs(i, count + 1, str + i);
					visit[i] = false;
				}
			}
		}
	}

}

