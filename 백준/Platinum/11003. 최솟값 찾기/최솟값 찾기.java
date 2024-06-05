import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Node> mydeque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int now = arr[i];

            while (!mydeque.isEmpty() && mydeque.getLast().value > now) {
                mydeque.removeLast();
            }

            mydeque.addLast(new Node(i, now));

            if (mydeque.getFirst().index <= i - l) {
                mydeque.removeFirst();
            }

            sb.append(mydeque.getFirst().value).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
    }

    static class Node {
        public int value;
        public int index;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
