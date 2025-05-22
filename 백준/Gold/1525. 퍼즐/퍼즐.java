import java.io.*;
import java.util.*;

public class Main {

	static int[] dy = new int[]{-1,0,0,1};
	static int[] dx = new int[]{0,-1,1,0};
	static String goal = "123456780";

	static class Point{
		int y;
		int x;
		int cnt;
		String s;

		Point(int y, int x, int cnt, String s){
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.s = s;
		}
	}


	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String init = "";
		int sX = 0;
		int sY = 0;

		for(int i=0; i<3; i++){
			String[] str = br.readLine().split(" ");
			for(int j=0; j<3; j++){
				init += str[j];

				//초기 0의 x, y 지점 찾기
				if(str[j].equals("0")){
					sX = j;
					sY = i;
				}
			}
		}

		int ans = bfs(init, sY, sX);

		System.out.println(ans);

	}

	static int bfs(String puzzle, int sY, int sX){
		Queue<Point> q = new LinkedList<>();
		Set<String> visited = new HashSet<>();
	
		q.add(new Point(sY, sX,0, puzzle));
		visited.add(puzzle);
	
		while(!q.isEmpty()){
			Point now = q.poll();
	
			if(now.s.equals(goal)){
				return now.cnt;
			}
	
			for(int i=0; i<4; i++){
				int ny = dy[i] + now.y;
				int nx = dx[i] + now.x;
	
				if(0<=ny && ny < 3 && 0<=nx && nx < 3){
	
					int zeroIndex = now.y * 3 + now.x;
					int swapIndex = ny * 3 + nx;
	
					StringBuilder sb = new StringBuilder(now.s);
					char temp = sb.charAt(swapIndex);
					sb.setCharAt(swapIndex, '0');
					sb.setCharAt(zeroIndex, temp);
	
					String newPuzzle = sb.toString();
					
					if(!visited.contains(newPuzzle)){
						visited.add(newPuzzle);
						q.add(new Point(ny, nx, now.cnt + 1, newPuzzle));
					}
				}
			}
		}
	
		return -1;
	}
	

}