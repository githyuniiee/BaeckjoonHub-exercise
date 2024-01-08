import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String str = (a * b * c) + "";
        int result = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < str.length(); j++) {
                if (i == Character.getNumericValue(str.charAt(j))) {
                    result ++;
                }
            }
            System.out.println(result);
            result = 0;
        }


    }
}