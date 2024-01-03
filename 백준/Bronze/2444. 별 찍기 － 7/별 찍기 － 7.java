import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append('*');


        for (int i = 0; i < (2*n)-1 ; i++) {
            if(i < n) {
                for (int j = n-1; j > i; j--) {
                    System.out.print(' ');
                }
                System.out.print(sb);
                for (int k = 0; k < 2; k++) {
                    sb.append('*');
                }
                System.out.println();
            }else{
                if(i == n){
                    sb.delete(0,2);
                }
                for (int j = 0; j < (i+1)-n; j++) {
                    System.out.print(' ');
                }
                sb.delete(0,2);
                System.out.print(sb);
                System.out.println();
            }

        }

    }
}