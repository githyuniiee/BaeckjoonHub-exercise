import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Map<Integer, Integer> sushiMap = new HashMap<>();
        int maxCount = 0;
        int currentCount = 0;

        for(int i=0; i<k; i++){
            sushiMap.put(arr[i], sushiMap.getOrDefault(arr[i], 0) + 1);
        }

        currentCount = sushiMap.size();
        if(!sushiMap.containsKey(c)){
            currentCount++;
        }
        maxCount = currentCount;

        for(int i=0; i<n; i++){

            int left = arr[i];
            sushiMap.put(left, sushiMap.get(left) - 1);
            if(sushiMap.get(left) == 0){
                sushiMap.remove(left);
            }

            int right = arr[(i+k) % n];
            sushiMap.put(right, sushiMap.getOrDefault(right, 0) + 1);

            //초밥 개수 갱신
            currentCount = sushiMap.size();
            if(!sushiMap.containsKey(c)){
                currentCount++;
            }

            maxCount = Math.max(maxCount, currentCount);

        }

        System.out.println(maxCount);

   
    }
}