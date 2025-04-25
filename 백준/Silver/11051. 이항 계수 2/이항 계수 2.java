import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n+1][k+1];

        int result = getC(n,k);

        System.out.println(result);
       
    }

    static int getC(int n, int k){

      if(arr[n][k] != 0) return arr[n][k];

      if(n==k || k == 0){
        arr[n][k] = 1;
      }else{
        arr[n][k] = (getC(n-1, k-1) + getC(n-1, k)) % 10007;
      }

      return arr[n][k];
    }

}