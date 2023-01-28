import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();


        sb.append(str);


        char[] arr = new char[26];
        int[] arr2 = new int[26];
        int num = 1;
        char alpha = 'A';

        for(int i=0; i<26; i++){
            arr[i] = alpha++;
        }

        for(int j=0; j<26; j++){
            arr2[j] = num++;
        }

        int sum = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<sb.length(); j++) {
                if (sb.charAt(j) == arr[i]){
                    sum += arr2[i];
                }
            }
        }
        System.out.println(sum);








    }
}