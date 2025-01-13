import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            sb = new StringBuilder();
            int first = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[first];

            for (int j = 0; j < first; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int second = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < second; j++) {
                int num = Integer.parseInt(st.nextToken());
                binarySearch(num);

            }

            System.out.print(sb);
        }

    }

    public static void binarySearch(int num){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){

            int middle = (start + end) / 2;
            if(arr[middle] == num){
                sb.append("1").append("\n");
                return;
            }

            if(arr[middle] < num) {
                start = middle + 1;
            }else{
                end = middle - 1;
            }
        }

        sb.append("0").append("\n");
    }
}
