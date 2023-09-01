

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int M; // 배추밭 가로 길이
    static int N; // 배추밭 세로 길이
    static int K; // 배추가 심어져 있는 위치
    static int[] dr = {-1,1,0,0}; //상하좌우
    static int[] dc = {0,0,-1,1}; //상하좌우
    static int[][] map; //배추밭
    static boolean[][] visit; //방문체크

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 배추밭 가로길이
            N = Integer.parseInt(st.nextToken()); // 배추밭 세로길이
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            visit = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int count = 0; //구역 수

            //배추가 있으면 dfs 탐색 시작하고, 구역 수 증가
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    // 배추가 있으면서 방문하지 않았으면 dfs 탐색하고 구역 수 1증가
                    if(map[j][k] == 1 && !visit[j][k]){
                        dfs(j,k);
                        count ++;
                    }
                }
            }

            System.out.println(count);

        }
    }

    public static void dfs(int r, int c) {
        //방문 체크
        visit[r][c] = true;


        //4방면 탐색
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            //범위 안에 있으면서
            if (nr >= 0 && nc >= 0 && nr < M && nc < N) {
                if(map[nr][nc] == 1 && !visit[nr][nc]){
                    dfs(nr, nc);
                }
            }
        }
    }

}
