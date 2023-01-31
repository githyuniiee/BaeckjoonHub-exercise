import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws  IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){
            String str = br.readLine();
            String[] arr = str.split(" "); //공백 단위로 나눠 배열에 저장
            
            System.out.print("Case #" + (i+1) +": ");
            for(int j=arr.length-1; 0<=j; j--){
                System.out.print(arr[j] + " ");// 띄워서 출력
            }
            System.out.println();
        }


    }
}