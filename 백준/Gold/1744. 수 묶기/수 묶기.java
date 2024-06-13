import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //양수는 내림차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> mq = new PriorityQueue<>();
        int zero = 0;
        int one = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else if (num > 0) {
                pq.add(num);
            }else{
                mq.add(num);
            }
        }

        while (pq.size() >1) {
            int a = pq.poll();
            int b = pq.poll();

            result += a*b;
        }
        if (pq.size() == 1) {
            result += pq.poll();
        }

        while (mq.size() > 1) {
            int a = mq.poll();
            int b = mq.poll();

            result += a*b;
        }
        if (!mq.isEmpty()) {
            if (zero == 0) {
                result += mq.remove();
            }
        }

        result += one;

        System.out.println(result);




    }
}
