import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();

        for (int i = 0; i < num.length(); i++) {
            int target = Character.getNumericValue(num.charAt(i)); //char -> int
            String s = Integer.toBinaryString(target); //2진수를 StringBuilder에 넣기
            if (s.length() == 3) {
                sb.append(s);
            } else if (s.length() == 2 && i != 0) {
                sb.append("0" + s);
            } else if (s.length() == 1 && i != 0) {
                sb.append("00" + s);
            } else sb.append(s);
        }
        
        System.out.println(sb.toString());

    }
}
