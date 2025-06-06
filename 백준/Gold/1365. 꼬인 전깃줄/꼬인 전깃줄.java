import java.util.*; 
import java.io.*;
public class Main { 
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(br.readLine()); 
        String str[] = br.readLine().split(" "); 
        int arr[] = new int[n]; 
        arr[0] = Integer.parseInt(str[0]); 
        int size = 1; 
        for (int i = 1; i < n; i++) { 
            int h = Integer.parseInt(str[i]); 
            if (arr[size - 1] < h) 
                arr[size++] = h; 
            else { 
                int left = 0; 
                int right= size; 
                int mid = 0; 
                while (left < right) { 
                    mid = (left + right) / 2; 
                    if (arr[mid] < h) left = mid + 1; 
                    else right = mid; 
                } 
                arr[right] = h; 
            } 
        } 
        bw.write(String.valueOf(n-size)); 
        bw.flush(); 
    } 
}