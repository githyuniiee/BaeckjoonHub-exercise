import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];

        //데이터 입력
        for(int i=0; i<n; i++){
            data[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(data);


        long sum = 0;

        for(int i=0; i<n; i++){
            sum += Math.abs((i+1) - data[i]);
        }

        System.out.println(sum);

   
    
        
       
    }
}