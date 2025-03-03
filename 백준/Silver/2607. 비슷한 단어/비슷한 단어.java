import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int result = 0;

        for(int i=0; i<n-1; i++){

            int[] alpha = new int[26];
            int cnt = 0; //같은 단어 개수

            for(int j=0; j<str.length(); j++){
                alpha[str.charAt(j) - 'A']++;
            }

            String str2 = br.readLine();

            for(int j=0; j<str2.length(); j++){
                if(alpha[str2.charAt(j) - 'A'] > 0){
                    cnt++;
                    alpha[str2.charAt(j) - 'A']--;
                }
            }

            //글짜 길이 같을때
            if(str.length() == str2.length() && (str.length() == cnt || str.length() - 1 == cnt)){
                result++;
            }

            //글짜 길이 작을때
            if(str.length() == str2.length() - 1 && (str2.length() -1 == cnt)){
                result++;
            }

            //클 때
            if(str.length() == str2.length() + 1 && (str2.length() == cnt)){

                result++;
            }

        }

        System.out.println(result);


    }
}