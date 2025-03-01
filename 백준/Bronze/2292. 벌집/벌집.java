import java.io.*;

public class Main {

    static String[] channel;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ans = 1;
        int now = 1;

        while(true){

            if(n <= now){
                break;
            }

            now += (6*ans);

            ans++;

        }

        System.out.println(ans);


        
    }
}