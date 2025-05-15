import java.io.*;
import java.util.*;

public class Main {


	static int[][] arr;
	static boolean[][][] visited;
	static int n,m;
	static int answer = 0;

	static int dy[] = new int[]{-1,0,0,1};
	static int dx[] = new int[]{0,-1,1,0};

	static class Point{
		int y;
		int x;
		boolean breakWall;
		int cnt;
		
		Point(int y, int x, boolean breakWall, int cnt){
			this.y = y;
			this.x = x;
			this.breakWall = breakWall;
			this.cnt = cnt;
			
		}
	}

    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visited = new boolean[n][m][2];

		for(int i=0; i<n; i++){
			String str = br.readLine();
			for(int j=0; j<str.length(); j++){
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		answer = bfs(0,0);

		System.out.println(answer);
		
	}

	static int bfs(int y, int x){

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(y, x, false, 1));
		visited[y][x][0] = true;

		while(!q.isEmpty()){
			Point now = q.poll();

			if(now.y == n-1 && now.x == m-1){
				return now.cnt;
			}

			for(int i=0; i<4; i++){
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];

				if(0<=ny && ny < n && 0<=nx && nx < m){

					//벽을 깬 경우
					if(now.breakWall){
						//벽이 아닌 경우
						if(arr[ny][nx] == 0 && !visited[ny][nx][1]){
							visited[ny][nx][1] = true;
							q.add(new Point(ny, nx, true, now.cnt + 1));
						}
					}else{
					//벽을 깨지 않은 경우

						if(arr[ny][nx] == 0 && !visited[ny][nx][0]){ //벽이 아닌 경우
							visited[ny][nx][0] = true;
							q.add(new Point(ny, nx, false, now.cnt + 1));
						}else if(arr[ny][nx] == 1 && !visited[ny][nx][1]){ //벽인 경우
							visited[ny][nx][1] = true;
							q.add(new Point(ny, nx, true, now.cnt + 1));
						}

					}	
				}
			}
		}

		return -1;

	}

}