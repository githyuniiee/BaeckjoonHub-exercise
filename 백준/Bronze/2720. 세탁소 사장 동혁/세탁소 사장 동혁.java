import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int a = 25;
        int b = 10;
        int c = 5;
        int d = 1;


        for (int i = 0; i < n; i++) {

            int money = Integer.parseInt(br.readLine());


            int result = money / a;
            System.out.print(result + " ");
            money = money % a;

            result = money / b;
            System.out.print(result + " ");
            money = money % b;

            result = money / c;
            System.out.print(result + " ");
            money = money % c;

            result = money / d;
            System.out.println(result + " ");




        }




    }
}