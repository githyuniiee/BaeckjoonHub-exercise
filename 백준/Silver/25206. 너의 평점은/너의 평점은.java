import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double score[] = new double[20];
        double grade[] = new double[20];

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            score[i] = Double.parseDouble(st.nextToken());
            String gr = st.nextToken();

            if(gr.equals("A+")){
                grade[i] = 4.5;
            } else if (gr.equals("A0")) {
                grade[i] = 4.0;
            } else if (gr.equals("B+")) {
                grade[i] = 3.5;
            } else if (gr.equals("B0")) {
                grade[i] = 3.0;
            } else if (gr.equals("C+")) {
                grade[i] = 2.5;
            } else if (gr.equals("C0")) {
                grade[i] = 2.0;
            } else if (gr.equals("D+")) {
                grade[i] = 1.5;
            } else if (gr.equals("D0")) {
                grade[i] = 1.0;
            }else if (gr.equals("F")){
                grade[i] = 0.0;
            }else{
                //p일 때
                grade[i] = -1;
            }
        }

        double sum = 0;
        double total = 0;
        for (int i = 0; i < grade.length; i++) {
            if(grade[i] != -1){
                sum += score[i];
                total += score[i] * grade[i];
            }
        }

        System.out.println(total/sum);

    }
}
