import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());



        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++){
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            sb.append(q.poll()).append(" ");
            if (q.isEmpty()) {
                break;
            }
            q.add(q.poll());

        }
        System.out.println(sb);

    }
}