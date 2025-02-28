import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n-1;
        int min = Integer.MAX_VALUE;
        int n1 = 0;
        int n2 = 0;

        while(left < right){

            if(Math.abs(arr[left] + arr[right]) < min){
                n1 = arr[left];
                n2 = arr[right];

                min = Math.abs(arr[left] + arr[right]);
            }

            if(arr[left] + arr[right] < 0){
                left++;

            }else if(arr[left] + arr[right] > 0){
                right--;

            }else{
                break;
            }
        }

        System.out.println(n1 +  " " + n2);

        
        


   
    }
}