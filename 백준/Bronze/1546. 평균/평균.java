import java.io.*;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] score = new double[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        double max = Integer.MIN_VALUE;
        double avg = 0;

        for(int i=0; i<n; i++){
            score[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, score[i]);
        }


        for(int i=0; i<n; i++){
            score[i] = score[i]/max*100;
            avg += score[i];
        }

        System.out.println(avg/n);




    }

}
