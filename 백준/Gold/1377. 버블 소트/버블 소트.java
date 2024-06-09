import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        mData[] A = new mData[n];

        for (int i = 0; i < n; i++) {
            A[i] = new mData(Integer.parseInt(br.readLine()), i);
        }


        Arrays.sort(A);
        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, A[i].index - i);
        }
        System.out.println(max + 1);

    }
}

class mData implements Comparable<mData> {
    int value;
    int index;

    public mData(int value, int index){
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o) {
        return this.value - o.value;
    }
}

