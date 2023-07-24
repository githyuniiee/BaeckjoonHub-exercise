import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Grade implements Comparable<Grade> {
    int a;
    int b;

    Grade(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Grade o) {
        if (this.a > o.a) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        ArrayList<Integer> results = new ArrayList<>();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Grade> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.add(new Grade(a, b));
            }

            Collections.sort(list); // 서류 점수 기준 오름차순 정렬

            int ans = 1; // 서류 1등은 무조건 통과
            int min = list.get(0).b; // 면접 점수 최소값
            for (int i = 1; i < N; i++) { // 서류 2등부터 시작
                if (list.get(i).b < min) { // 이전의 최소 면접 점수보다 낮으면 통과
                    ans++;
                    min = list.get(i).b; // 최소 점수 갱신
                }
            }
            results.add(ans);
        }

        // Print the results
        for (int result : results) {
            System.out.println(result);
        }
    }
}