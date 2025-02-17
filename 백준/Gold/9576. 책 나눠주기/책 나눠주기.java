import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    
    static int n, m;
    static ArrayList<Integer>[] books; // 각 책을 빌릴 수 있는 학생 리스트
    static int[] matched; // 각 책에 매칭된 학생
    static boolean[] visited; // DFS 방문 여부
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 책의 개수
            m = Integer.parseInt(st.nextToken()); // 학생의 수
            
            books = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                books[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                for (int j = a; j <= b; j++) {
                    books[j].add(i + 1); // 학생 i+1이 빌릴 수 있는 책 j 등록
                }
            }

            matched = new int[m + 1]; // 각 학생이 매칭된 책
            int ans = 0;
            
            for (int i = 1; i <= n; i++) {
                visited = new boolean[m + 1];
                if (dfs(i)) {
                    ans++;
                }
            }
            
            System.out.println(ans);
        }
    }
    
    static boolean dfs(int book) {
        for (int student : books[book]) {
            if (visited[student]) continue;
            visited[student] = true;
            
            // 학생이 아직 책을 배정받지 않았거나, 현재 배정된 책을 다른 학생에게 넘길 수 있는 경우
            if (matched[student] == 0 || dfs(matched[student])) {
                matched[student] = book;
                return true;
            }
        }
        return false;
    }
}
