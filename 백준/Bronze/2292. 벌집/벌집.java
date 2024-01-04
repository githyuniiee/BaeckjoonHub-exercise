import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[1000000];
        arr[0] = 1;


        for (int i = 0; i < arr.length -1 ; i++) {
            arr[i+1] = arr[i] + (6*(i+1));
        }

        for (int i = 0; i < arr.length -1 ; i++) {
            if(num <= arr[i]){
                System.out.println(i+1);
                break;
            }
        }


    }
}