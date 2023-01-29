import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        if(2<=N || N<=100000) {
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            int cnt = 1;
            int max = arr[N-1];


            for (int i = N-1; i >= 0; i--) {
                if (arr[i] > max) {
                    max = arr[i];
                    cnt++;
                }
            }

            System.out.println(cnt);
        }


    }
}