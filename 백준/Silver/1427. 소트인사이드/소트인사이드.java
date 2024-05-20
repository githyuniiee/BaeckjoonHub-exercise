import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Integer[] arr = new Integer[str.length()];

        for(int i=0; i<str.length(); i++){
            arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for(int a : arr){
            System.out.print(a);
        }

    }
}
