import java.io.*;
 
public class Main {
 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
        long cnt = 0;

        if(n == 0){
            System.out.println(cnt);
            return;
        }

        if(n == 1){
            cnt++;
            System.out.println(cnt);
            return;
        }

        if(n == 2){
            cnt = 2;
            System.out.println(cnt);
            return;
        }

        cnt = 2;
        long now = 2;
        while(n >= 3 && now < n){
            now *= 2;
            cnt++;
        }

        System.out.println(cnt);





        
		

	}

	
}