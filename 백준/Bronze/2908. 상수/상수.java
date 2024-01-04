import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        StringBuilder sb = new StringBuilder();
        for (int i = a.length() -1 ; i >= 0; i--) {
            sb.append(a.charAt(i));
        }

        StringBuilder sb1 = new StringBuilder();
        for (int i = b.length() -1 ; i >= 0; i--) {
            sb1.append(b.charAt(i));
        }

        int r1 = Integer.parseInt(String.valueOf(sb));
        int r2 = Integer.parseInt(String.valueOf(sb1));

        if(r1 < r2){
            System.out.println(r2);
        }else{
            System.out.println(r1);
        }

    }
}