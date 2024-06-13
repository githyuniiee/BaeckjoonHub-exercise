import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            queue.add(num);
        }

        int sum = 0;

        while (!queue.isEmpty()) {

            if(queue.size() > 1){
                int a = queue.poll();
                int b = queue.poll();
                int c = a+ b;

                sum += c;
                queue.add(c);
            }else{
                queue.poll();

            }
        }

        System.out.println(sum);

    }
}
