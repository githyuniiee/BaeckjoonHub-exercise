import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];
        int[] sum = new int[10];
        int answer = 0;

        for(int i=0; i<10; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        sum[0] = arr[0];
        for(int i=1; i<10; i++){
            sum[i] = sum[i-1] + arr[i];
        }
//        System.out.println(sum[9]);

        int min = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;

        for(int i=0; i<10; i++){
            if(sum[i] >= 100){
                max = Math.min(max, sum[i] - 100);

            }else{
                min = Math.min(min, 100 - sum[i]);

            }
        }

        if(max > min){
            answer = 100- min;
        }else{
            answer = 100 + max;
        }

        System.out.println(answer);



    }
}
