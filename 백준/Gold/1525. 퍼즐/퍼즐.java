import java.io.*;
import java.util.*;

public class Main {

	static String goal = "123456780";
	static int[] dy = new int[]{-1,0,0,1};
	static int[] dx = new int[]{0,-1,1,0};
	static Map<String, Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String init = "";

		for(int i=0; i<3; i++){
			String[] arr = br.readLine().split(" ");
			for(int j=0; j<3; j++){
				init += arr[j];
			}
		}
		map.put(init, 0);
		System.out.println(bfs(init));
	}

	static int bfs(String init){
		Queue<String> q = new LinkedList<>();
		q.add(init);

		while(!q.isEmpty()){
			String now = q.poll();
			int move = map.get(now);

			//0위치 찾기
			int empty = now.indexOf('0');
			int px = empty % 3;//x좌표
			int py = empty / 3; //y좌표

			if(now.equals(goal)){
				return move;
			}

			for(int i=0; i<4; i++){
				int ny = py + dy[i];
				int nx = px + dx[i];

				if(0<=ny && ny <3 && 0<= nx && nx < 3){
					int nPos = ny*3 + nx; //움직일 숫자 인덱스
					char ch = now.charAt(nPos);

					String next = now.replace(ch, 'c');
					next = next.replace('0', ch);
					next = next.replace('c', '0');


					if(!map.containsKey(next)){
						q.add(next);
						map.put(next, move + 1);
					}

				}
			}
		}
		return -1;
	}
}