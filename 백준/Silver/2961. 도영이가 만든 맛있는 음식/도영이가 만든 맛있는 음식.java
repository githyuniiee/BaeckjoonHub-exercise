import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] s, b; //각 재료의 신맛, 쓴맛 저장 배열
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); // 재료의 개수 입력 받기

        s = new int[n]; //신맛 저장할 배열 초기화
        b = new int[n]; //쓴맛 저장할 배열 초기화

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        ans = Integer.MAX_VALUE;
        powerSet(0, new boolean[n]); //부분집합 구하기
        sb.append(ans);
        System.out.println(sb);
    }

    public static void powerSet(int i, boolean[] v){

        if(i == v.length){
            int ss = 1, bs = 0, c= 0; //신맛, 쓴맛, 미사용된 재료의 개수 저장할 변수
            for (int j = 0; j < v.length; j++) {
                if (v[j]) { //현재 재료를 선택했을 때
                    ss *= s[j]; //신맛에 현재 재료의 신맛 곱하기
                    bs += b[j];
                }else {
                    c++; //미사용된 재료의 개수 증가
                }
            }
            if (c != v.length) { //모든 재료를 사용한 경우가 아닐 때
                ans = Math.min(ans, Math.abs(ss - bs)); //현재까지의 결과값 갱신
            }
            return;
        }

        //현재 재료를 사용하는 경우와 사용하지 않는 경우 모두 탐색
        v[i] = true; //사용하는 경우
        powerSet(i+1, v); //다음 재료로 넘어감
        v[i] = false; //현재 재료를 사용하지 않는 경우
        powerSet(i+1, v); //다음 재료로 넘어감
    }

}


