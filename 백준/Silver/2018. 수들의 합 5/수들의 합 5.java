import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int start = 1;
        int end = 1;
        int answer = 0;


        for(int i=1; i<=n; i++){
            arr[i] += arr[i-1] + i;

        }

        while(end <= n){


            if(arr[end] - arr[start] > n){
                start++;
            }else if(arr[end] - arr[start] <= n){
                if(arr[end] - arr[start] == n || arr[end]== n){
//                    System.out.println("end" + end + "start" + start);
                    answer++;
                }
                end++;
            }


        }

        System.out.println(answer);


    }
}
