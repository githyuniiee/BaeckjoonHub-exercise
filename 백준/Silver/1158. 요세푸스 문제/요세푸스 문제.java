import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<N; i++){
            queue.offer(i + 1);
        }

        while(queue.size()!= 1){
            for(int i=0; i<K-1; i++){
                queue.offer(queue.poll());
            }
            sb.append(queue.peek() + ", ");
            queue.remove();
        }
        sb.append(queue.peek() + ">");
        System.out.println(sb);
    }
}

