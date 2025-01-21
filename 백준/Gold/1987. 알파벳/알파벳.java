import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

    static int R,C;
    static char[][] board;
    static int[] dy = new int[]{-1,0,0,1};
    static int[] dx = new int[]{0,1,-1,0};
    static int answer = 0;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); //세로
        C = Integer.parseInt(st.nextToken()); //가로

        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        HashSet<Character> set = new HashSet<>();
        dfs(0,0, set);

        System.out.println(answer);


    }

    static void dfs(int y, int x, HashSet<Character> set){
        set.add(board[y][x]);
        answer = Math.max(answer, set.size());

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(0<= ny && ny <R && 0<= nx && nx <C){
                if(!set.contains(board[ny][nx])) {
                    dfs(ny, nx, set);
                }

            }
        }

        set.remove(board[y][x]);


    }

}


