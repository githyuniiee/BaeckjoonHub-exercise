import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        int[] arr = new int[n+1];
        int[] answer1 = new int[n+1];
        int[] answer2 = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        //내림차순
        for(int i=n; i>=1; i--){
            answer2[i] = 1;
            for(int j=n; j>i; j--){
                if(arr[j] < arr[i]){

                    answer2[i] = Math.max(answer2[i], answer2[j] + 1);

                }
            }
        }

        //오름차순
        for(int i=1; i<=n; i++){
            for(int j=1; j<i; j++){
                if(arr[j] < arr[i]){

                    answer1[i] = Math.max(answer1[i], answer1[j] + 1);

                }
            }
            answer2[i] = answer2[i] + answer1[i];
            result = Math.max(result, answer2[i]);
        }
        

        System.out.println(result);

    }

}


