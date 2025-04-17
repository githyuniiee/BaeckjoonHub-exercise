import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        Arrays.sort(times);
        long start = 1;
        long end = (long) times[times.length - 1] * n;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (int time : times) {
                sum += mid / time;
            }

            if (sum >= n) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }
}
