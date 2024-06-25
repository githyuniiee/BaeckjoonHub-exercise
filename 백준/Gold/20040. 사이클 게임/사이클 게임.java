import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int arr[];
    static int cycle[];
    static int answer = 0;
    static boolean result = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        cycle = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
            cycle[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (find(x) == find(y)) {
                System.out.println(i + 1);
                return;
            }else{
                union(x,y);
            }
        }

        System.out.println(0);

    }


    static int find(int x) {
        if(x == arr[x]){
            return x;
        }
        return arr[x] = find(arr[x]);
    }

    static void union(int x, int y) {
        int parent_x = find(x);
        int parent_y = find(y);

        if (x < y) {
            arr[parent_y] = parent_x;
        }else{
            arr[parent_x] = parent_y;
        }

    }


}

