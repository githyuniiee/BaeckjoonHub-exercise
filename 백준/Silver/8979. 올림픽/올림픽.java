import java.io.*;
import java.util.*;

public class Main {

	static class Nation {
		int num;
		int g;
		int s;
		int m;

		Nation(int num,int g ,int s, int m){
			this.num = num;
			this.g = g;
			this.s = s;
			this.m = m;

		}
	}


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		PriorityQueue<Nation> pq = new PriorityQueue<>((o1,o2) -> {

			if(o1.g == o2.g){
				if(o1.s == o2.s){
					return o2.m - o1.m;
				}
				return o2.s - o1.s;

			}
			return o2.g - o1.g;
		});

		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());

			int number = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int metal = Integer.parseInt(st.nextToken());

			Nation nation = new Nation(number, gold, silver, metal);
			pq.add(nation);
		}

		int rank = 1;
		int sameRank = 1;

		Nation now = pq.poll();
		if(now.num == k){
			System.out.println(rank);
			return;
		}

		while(!pq.isEmpty()){

			Nation next = pq.poll();

			if(now.g==next.g && now.s == next.s && now.m == next.m){
				sameRank++;
			}else{
				//메달 개수가 다르면 갱신
				rank += sameRank;
				sameRank = 1;
			}
			now = next;

			if(k == now.num){
				System.out.println(rank);
				break;
			}
		}







    }
}