import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int t;
    static ArrayList<Integer> list;
    static int[] arr;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        int[] stair = new int[301];
        int[] score = new int[301];


        for (int i = 1; i <= t; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        score[1] = stair[1];
        score[2] = stair[1] + stair[2];
        score[3] = Math.max(stair[1], stair[2]) + stair[3];

        for (int i = 4; i <= t; i++) {
            score[i] = Math.max(score[i - 3] + stair[i - 1], score[i - 2]) + stair[i];
        }

        System.out.println(score[t]);

    }

}







