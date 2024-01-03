import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int result = 0;
        int count = 0;

        for (int i = 1; i <= a; i++) {
            if(a % i == 0) {
                count++;
            }

            if(count == b){
                result = i;
                break;
            }
        }
        System.out.println(result);

    }
}