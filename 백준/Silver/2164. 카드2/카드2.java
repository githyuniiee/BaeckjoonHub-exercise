import java.io.*;
import java.util.*;
import java.util.concurrent.DelayQueue;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

		Deque<Integer> deque = new LinkedList<>();

		for(int i=1; i<=n; i++){
			deque.add(i);
		}
		
		while(true){

			if(deque.size() == 1){
				break;
			}

			deque.pollFirst();

			if(deque.size() == 1){
				break;
			}

			deque.addLast(deque.pollFirst());
			
			if(deque.size() == 1){
				break;
			}
		}

		System.out.println(deque.pollFirst());

    }

}