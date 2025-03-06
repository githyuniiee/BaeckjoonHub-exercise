import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1000 - Integer.parseInt(br.readLine());
        int ans = 0;

        while(n != 0){
            
            if(n >= 500){
                ans += n / 500;
                n %= 500;
            }else if(n >= 100){
                ans += n / 100;
                n %= 100;
            }else if(n >= 50){
                ans += n / 50;
                n %= 50;
            }else if(n >= 10){
                ans += n / 10;
                n %= 10;
            }else if(n >= 5){
                ans += n / 5;
                n %= 5;
            }else{
                ans += n / 1;
                n %= 1;
            }
        }

        System.out.println(ans);

    }
}