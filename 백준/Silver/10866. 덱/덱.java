import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new LinkedList<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int num = 0;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    dq.addFirst(num = Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.addLast(num = Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append((dq.isEmpty() ? -1 : dq.removeFirst()) + "\n");
                    break;
                case "pop_back":
                    sb.append((dq.isEmpty() ? -1 : dq.removeLast()) + "\n");
                    break;
                case "size":
                    sb.append(dq.size() + "\n");
                    break;
                case "empty":
                    sb.append((dq.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    sb.append((dq.isEmpty() ? -1 : dq.peekFirst()) + "\n");
                    break;
                case "back":
                    sb.append((dq.isEmpty() ? -1 : dq.peekLast()) + "\n");
                    break;
            }

        }
        System.out.println(sb);

    }
}
