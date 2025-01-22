import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String find = br.readLine();
        int len = find.length();

        int start = 0;
        int end = len;
        int answer = 0;

        while(end <= str.length()){

            String search = str.substring(start, end);

            if(search.equals(find)){
                answer++;
                start = end;
                end += len;
            }else{
                start += 1;
                end += 1;
            }
        }

        System.out.println(answer);

    }


}
