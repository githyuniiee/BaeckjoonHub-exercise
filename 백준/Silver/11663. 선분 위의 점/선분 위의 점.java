import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            int start = lowerBound(arr, a);
            int end = upperBound(arr, b) -1;

            if(start > end){
                sb.append(0 + "\n");
            }else{
                sb.append(end - start + 1 + "\n");
            }
        }

        System.out.println(sb);

    }

    private static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;

        while(low < high){
            int mid = (low + high) / 2;
            if(arr[mid] < target){
                low = mid + 1;
            }else{
                high = mid;
            }
        }

        return low;
    }

    private static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;

        while(low < high){
            int mid = (low + high) / 2;
            if(arr[mid] <= target){
                low = mid + 1;
            }else{
                high = mid;
            }
        }

        return low;
    }


}


