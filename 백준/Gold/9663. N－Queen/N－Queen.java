import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int resultCount;
    static int[] board;

    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n];

        dfs(0);
        System.out.println(resultCount);
    }

    public static void dfs(int depth) {

        if (depth == n) {
            resultCount++;
            return;
        }

        for (int i = 0; i < n; i++) {
            board[depth] = i;

            if (possibility(depth)) {
                dfs(depth + 1);
            }
        }
    }

    public static boolean possibility(int depth) {

        for (int i = 0; i < depth; i++) {
            if(board[i] == board[depth]){
                return false;
            } else if (Math.abs(depth - i) == Math.abs(board[depth] - board[i])) {
                return false;
            }
        }

        return true;
    }
}

