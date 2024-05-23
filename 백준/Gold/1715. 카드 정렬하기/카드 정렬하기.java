import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();


        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            queue.add(num);
        }

        int sum = 0;
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            int cost = a + b;
            sum += cost;
            queue.add(cost);
        }
        System.out.println(sum);




    }

}