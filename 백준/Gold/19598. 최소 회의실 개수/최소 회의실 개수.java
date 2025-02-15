import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    static class Room{
        int s;
        int e;

        Room(int s, int e){
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Room> list = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            list.add(new Room(first, second));
        }

        Collections.sort(list, ((o1,o2) -> o1.s - o2.s));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(list.get(0).e);

        for(int i=1; i<n; i++){
            if(list.get(i).s >= pq.peek()){
                pq.poll();
            }

            pq.offer(list.get(i).e);
        }

        System.out.println(pq.size());
    }

    


}
