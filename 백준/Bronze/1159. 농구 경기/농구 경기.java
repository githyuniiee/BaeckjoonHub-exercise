import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer num = Integer.parseInt(br.readLine());
        Character arr[] = new Character[num];
        String result = "";

        for (int i = 0; i < num; i++) {
            arr[i] = (br.readLine()).charAt(0);
        }

        Arrays.sort(arr);

        for (int i = 0; i < num-1; i++) {
            int count = 0;
            for (int j = i + 1; j < num; j++) {
                if(arr[i] == arr[j] && arr[j] != '0') {
                    count ++;
                    arr[j] = '0';
                }
            }
            if(count > 3 ){
                result += arr[i];
            }
        }

        if(result.equals("")) {
            System.out.println("PREDAJA");
        }
        else{
            System.out.println(result);
        }

    }
}
