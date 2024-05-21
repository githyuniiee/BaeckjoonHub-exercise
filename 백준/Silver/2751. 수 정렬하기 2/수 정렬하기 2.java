import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] temp;

    static void mergeSort(int left, int right, int[] arr){
        int mid;
        if(left < right){
            mid = (left + right)/2;
            mergeSort(left, mid, arr);
            mergeSort(mid+1, right, arr);
            merge(left, right, mid, arr);
        }
    }

    static void merge(int left, int right, int mid, int[] arr) {
        int l = left; // 왼쪽 부분리스트 시작점
        int r = mid + 1; // 오른쪽 부분리스트 시작점
        int idx = left; // 채워넣을 배열 인덱스

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[idx] = arr[l];
                l++;
            } else {
                temp[idx] = arr[r];
                r++;
            }
            idx++;
        }

        /*
         * 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (l > mid)
         * = 오른쪽 부분리스트 원소가 아직 남아있을 경우
         * 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
         */
        if(l > mid) {
            while(r <= right) {
                temp[idx] = arr[r];
                idx++;
                r++;
            }
        }

        /*
         * 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (r > right)
         * = 왼쪽 부분리스트 원소가 아직 남아있을 경우
         * 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
         */
        else {
            while(l <= mid) {
                temp[idx] = arr[l];
                idx++;
                l++;
            }
        }


        // temp 배열의 내용을 원래 배열로 복사
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }



    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        temp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, arr.length - 1, arr);

        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
    }
}
