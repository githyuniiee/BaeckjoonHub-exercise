import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String find = br.readLine();
        int find_len = find.length();
        int count = 0;

        int start = 0;
        while (true) {
            if(start+find_len > str.length()) break;
            String a = str.substring(start, start + find_len);
            if(a.equals(find)){
                count++;
                start = start + find_len;
            }else{
                start++;
            }
        }

        System.out.println(count);


    }

}
