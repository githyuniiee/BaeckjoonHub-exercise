import java.io.*;
import java.util.*;

public class Main {


    static int[] lectures;
    static int N;

    public static int lowerBound(int start, int end, int target) {

        while(start < end){
            int mid = (start + end) / 2;
            if(getCount(mid) > target){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return start;
    }

    public static int getCount(int mid) {
        int count = 1;
        int remain = mid;
        for (int i = 0; i < N; i++) {
            if(remain < lectures[i]){
                remain = mid;
                count++;
            }
            remain -= lectures[i];
        }

        return count;

    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        lectures = new int[N];
        int sum = 0;
        int maxBlueray = 0;
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            sum += lectures[i];
            maxBlueray = Math.max(maxBlueray, lectures[i]);
        }
        System.out.println(lowerBound(maxBlueray, sum, M));
    }

}