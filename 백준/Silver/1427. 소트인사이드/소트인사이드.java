import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char ch[] = br.readLine().toCharArray();


        Arrays.sort(ch);

        for (int i = ch.length-1; i >= 0 ; i--) {
            System.out.print(ch[i]);
        }




    }
}




