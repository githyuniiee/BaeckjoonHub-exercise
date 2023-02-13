import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!q.isEmpty()){
            for (int i = 0; i < K-1; i++) {
                q.add(q.remove());
            }
            if(q.size() != 1) {
                sb.append(q.remove() + ", ");
            }else{
                sb.append(q.remove());
            }
        }


        System.out.println(sb + ">");



    }
}



