import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());



        int[] arr = new int[B];
        int num = 1;
        int k = 0;

        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < num; j++) {
                if(k >= arr.length) break;
                arr[k] = num;
                ++k;
            }
           ++num;

        }

        int result = 0;
        for(int l = A-1; l < B; l++){
            result += arr[l];
        }

        System.out.println(result);
    }
}
