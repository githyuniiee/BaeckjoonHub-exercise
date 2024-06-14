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
        String example = br.readLine();
        String[] minus = example.split("-");
        int answer = 0;

        for (int i = 0; i < minus.length; i++) {
            int temp = mySum(minus[i]);
            if(i==0){
                answer += temp;
            }else{
                answer -= temp;
            }
        }

        System.out.println(answer);

    }

    static int mySum(String a) {

        if(a.equals("")) return 0;
        String[] plus = a.split("[+]");
        int sum = 0;

        for (int i = 0; i < plus.length; i++) {
            sum += Integer.parseInt(plus[i]);
        }

        return sum;
    }
}
