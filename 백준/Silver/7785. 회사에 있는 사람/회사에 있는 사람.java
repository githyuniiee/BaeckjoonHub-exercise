import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<String> sortedSet = new TreeSet<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] arr = str.split(" ");

            if(arr[1].equals("enter")){
                sortedSet.add(arr[0]);
            }else{
                sortedSet.remove(arr[0]);

            }
        }

        for (String st : sortedSet) {
            System.out.println(st);
        }
    }
}

