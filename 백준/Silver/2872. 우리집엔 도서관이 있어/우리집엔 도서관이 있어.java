import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int idx = 0;

		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] == n){
				idx = i;
			}
		}

		int cnt = 1; //내림차순 연속 부분 수열의 길이
		int tmp = n - 1; //가장 큰 숫자(n) 바로 앞에 와야 하는 숫자 추적
		idx -= 1; //n 위치 한 칸 앞 부터 검사
		for (int i = idx; i >= 0; i--) {
            // 내림차순인지 검사
            if (arr[i] == tmp) {
                cnt++;
                tmp--;
            }
        }
        System.out.println(n - cnt);
		
	}
}