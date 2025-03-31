
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

	static int n,l,r;
	static int[][] arr;
	static boolean[][] visited;
	static int[]dy = new int[]{-1,0,0,1};
	static int[]dx = new int[]{0,-1,1,0};
	static ArrayList<Point> list;

	static class Point{
		int y;
		int x;

		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
	}

    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		arr = new int[n][n];

		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(move());
	
	}

	static int move(){
		int result = 0;
		while(true){
			boolean isMove = false;
			visited = new boolean[n][n];
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(!visited[i][j]){
						int sum = bfs(i,j); //이동할 총 인구 수 
						if(list.size() > 1){
							cahngePopulation(sum);
							isMove = true;
						}

					}
				}
			}
			if(!isMove) return result;
			result++;
		}
	}



	static int bfs(int y, int x){
		
		Queue<Point> q = new LinkedList<>();
		list = new ArrayList<>();

		q.add(new Point(y, x));
		visited[y][x] = true;
		list.add(new Point(y, x));

		int sum = arr[y][x];

		while(!q.isEmpty()){
			Point now = q.poll();

			for(int i=0; i<4; i++){
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];

				if(0<= ny && ny < n && 0<=nx && nx < n){
					if(!visited[ny][nx] && Math.abs(arr[now.y][now.x] - arr[ny][nx]) >= l 
					&& Math.abs(arr[now.y][now.x] - arr[ny][nx]) <= r){
						visited[ny][nx] = true;
						q.add(new Point(ny, nx));
						list.add(new Point(ny,nx));
						sum += arr[ny][nx];
					}
				}
			}
		}

		return sum;

	}

	static void cahngePopulation(int sum){
		int avg = sum / list.size();
		for(Point p : list){
			arr[p.y][p.x] = avg;
		}
	}




	



}
