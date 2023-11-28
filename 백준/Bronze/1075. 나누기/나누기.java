import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());
        Integer f = Integer.parseInt(br.readLine());

        n /= 100;
        n *= 100;

        while( n % f != 0){
            n++;
        }

        String str = String.valueOf(n);
        char a = str.charAt(str.length()-2);
        char b = str.charAt(str.length()-1);

        System.out.print(a);
        System.out.println(b);


    }
}
