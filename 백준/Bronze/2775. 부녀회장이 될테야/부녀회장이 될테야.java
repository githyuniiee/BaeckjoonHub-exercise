import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int arr[][] = new int[15][15];

        for (int i = 0; i < arr.length; i++) {
            arr[0][i] = i; //0층
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                for(int l=1; l<=j; l++){
                    arr[i][j] += arr[i-1][l];
                }
            }
        }


        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(arr[k][n]);
        }










    }
}