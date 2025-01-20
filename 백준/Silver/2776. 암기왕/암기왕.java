import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n1 = Integer.parseInt(br.readLine());
            int[] arr1 = new int[n1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n1; j++) {
                arr1[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr1);

            int n2 = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n2; j++) {
                int num = Integer.parseInt(st.nextToken());

                int left = 0;
                int right = n1 - 1;
                boolean isTrue = false;

                while(left <= right){
                    int mid = (left + right) / 2;

                    if(arr1[mid] <= num){
                        left = mid + 1;

                        if(arr1[mid] == num){
                            isTrue = true;
                            break;
                        }

                    }else{
                        right = mid -1;
                    }
                }

                if(isTrue){
                    sb.append(1 + "\n");
                }else{
                    sb.append(0 + "\n");
                }

            }

            System.out.println(sb.toString().trim());

        }


    }


}
