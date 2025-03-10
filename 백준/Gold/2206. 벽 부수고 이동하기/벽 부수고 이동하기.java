import java.io.*;
import java.util.*;

public class Main {

	static int n,m;
	static int[][] arr;
	static boolean[][][] visited;

	static int[] dy = new int[]{-1,0,0,1};
	static int[] dx = new int[]{0,-1,1,0};

	static class Point{
		int y;
		int x;
		int cnt;
		boolean breakWall;

		Point(int y, int x, int cnt, boolean breakWall){
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.breakWall = breakWall;
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
			for(int j=0; j<m; j++){
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		System.out.println(bfs());


    }

	static int bfs(){
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 1, false));

		while(!q.isEmpty()){
			Point now = q.poll();

			if(now.y == n-1 && now.x == m-1){
				return now.cnt;
			}

			for(int i=0; i<4; i++){
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];

				if(0<=ny && ny<n && 0<=nx && nx < m){

					//벽 이미 깸
					if(now.breakWall){

						if(arr[ny][nx] == 0 && !visited[ny][nx][1]){
							visited[ny][nx][1] = true;
							q.add(new Point(ny, nx, now.cnt + 1, true));
						}
					}else{

						if(arr[ny][nx] == 0 && !visited[ny][nx][0]){
							visited[ny][nx][0] = true;
							q.add(new Point(ny, nx, now.cnt + 1, false));
						}else if(arr[ny][nx] == 1 && !visited[ny][nx][1]){
							visited[ny][nx][1] = true;
							q.add(new Point(ny, nx, now.cnt + 1, true));
						}
					}
				}
			}
		}
		return -1;
	}


}