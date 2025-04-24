import java.io.*;
import java.util.*;

public class Main {


	static int n,m;
	static int matched[]; //전체 매칭 상태 유지 배열
	static boolean check[]; //한 명의 학생이 어떤 책에 접근했는지 체크
	static List<List<Integer>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++){

			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			list = new ArrayList<>();
			matched = new int[n+1];
			check = new boolean[n+1];
			
			for(int j=0; j<=m; j++){
				list.add(new ArrayList<>());
			}

			for(int j=1; j<=m; j++){
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				for(int k=a; k<=b; k++){
					list.get(j).add(k);
				}
			}

			int cnt = 0;
			for(int j=1; j<=m; j++){
				Arrays.fill(check, false);
				if(dfs(j)) cnt++;
			}

			System.out.println(cnt);
		}
		
    }


	static boolean dfs(int student){
		for(int book : list.get(student)){
			if(!check[book]){
				check[book] = true;

				if(matched[book] == 0 || dfs(matched[book])){
					matched[book] = student;
					return true;
				}
			}
		}

		return false;

	}


}