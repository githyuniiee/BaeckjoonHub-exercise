import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int r,c;
	static char[][] arr;
	static char[][] after;
	static int[] dy = new int[]{-1,0,0,1};
	static int[] dx = new int[]{0,-1,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new char[r][c]; //원본 배열
		after = new char[r][c]; //50년 후 배열

		for(int i=0; i<r; i++){
			Arrays.fill(arr[i], '.');
		}
   
		for(int i=0; i<r; i++){
			String str = br.readLine();
			for(int j=0; j<str.length(); j++){
				char ch = str.charAt(j);
				arr[i][j] = ch;
				after[i][j] = ch;
			}
		}

		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(arr[i][j] == 'X'){
					check(i,j);
				}
			}
		}

		int minRow = r, maxRow = 0;
		int minCol = c, maxCol = 0;
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(after[i][j] == 'X') {
					minRow = Math.min(minRow, i);
					maxRow = Math.max(maxRow, i);
					minCol = Math.min(minCol, j);
					maxCol = Math.max(maxCol, j);
				}
			}
		}
		
		for(int i = minRow; i <= maxRow; i++) {
			for(int j = minCol; j <= maxCol; j++) {
				System.out.print(after[i][j]);
			}
			System.out.println();
		}
		


    }

	//3칸 또는 4칸에 잠겨있는지 확인
	static void check(int y, int x){
		int cnt = 0;
	
		for(int i=0; i<4; i++){
			int ny = y + dy[i];
			int nx = x + dx[i];
	
			if(ny < 0 || ny >= r || nx < 0 || nx >= c || arr[ny][nx] == '.'){
				cnt++;
			}
		}
	
		if(cnt >= 3){
			after[y][x] = '.';
		}
	}
}