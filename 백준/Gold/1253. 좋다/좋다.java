import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long arr[] = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        int answer = 0;

        for (int k = 0; k < n; k++) {
            long find = arr[k];
            int i = 0;
            int j = n-1;

            while (i < j) {
                if(arr[i] + arr[j] == find){
                    //find는 서로 다른 두 수의 합 이어야 함
                    if (i != k && j != k) {
                        answer++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                }else if(arr[i] + arr[j] < find){
                    i++;
                }else{
                    j--;
                }
            }
        }

        System.out.println(answer);


    }
}