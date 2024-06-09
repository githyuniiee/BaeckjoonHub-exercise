import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {

            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            if (first_abs == second_abs) {
                return o1 > o2 ? 1 : -1;
            }else{
                return first_abs - second_abs;
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if (q.isEmpty()) {
                    bw.write( "0\n");

                }else{
                    bw.write(q.poll() + "\n");
                }
            }else{
                q.add(num);
            }
        }

        bw.flush();
        bw.close();
        br.close();




    }
}

