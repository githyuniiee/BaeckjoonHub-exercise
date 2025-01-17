import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] lesson = new int[n];
        int left = 0, right = 0, answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lesson[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, lesson[i]);
            right += lesson[i];
            answer += lesson[i];
        }

        while(left <= right){
            int mid = (left + right ) / 2;
            int count = 1;
            int sum = lesson[0];

            for (int i = 1; i < n; i++) {
                if(sum + lesson[i] > mid){
                    count++;
                    sum = lesson[i];
                }else{
                    sum += lesson[i];
                }
            }

            if(count > m){
                left = mid + 1;
            }else{
                right = mid -1;
                answer = Math.min(answer, mid);
            }
        }


        System.out.println(answer);









    }


}


