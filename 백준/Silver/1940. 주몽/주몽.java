import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = arr.length-1;
        int answer = 0;

        Arrays.sort(arr);

        while(start < end){

            if(arr[start] + arr[end] < m){
                start++;
            }else{
                if(arr[start] + arr[end] == m){
                    answer++;
                }
                end--;
            }


        }

        System.out.println(answer);

    }
}