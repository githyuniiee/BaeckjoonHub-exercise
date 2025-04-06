import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());


		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}


		Map<Integer, Integer> map = new HashMap<>();

		for(int i=0; i<k; i++){
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		map.put(c, map.getOrDefault(c, 0) + 1); //쿠폰 초밥 추가
		int ans = map.size();

		
		for (int i=1; i<n; i++) {
			//맨 처음 지우고
			int remove = arr[(i-1) % n];
			map.put(remove, map.get(remove) - 1);

			if(map.get(remove) == 0){
				map.remove(remove);
			}

			//하나 추가
			int add = arr[(i+k-1) %n];
			map.put(add, map.getOrDefault(add, 0) + 1);

			ans = Math.max(ans, map.size());

			
		}
		System.out.println(ans);



	
		
    }

}