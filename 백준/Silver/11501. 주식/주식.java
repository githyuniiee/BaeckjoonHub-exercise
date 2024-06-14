import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Main {
	
	public static int T, N;
	public static int[] arr;
	public static long answer = 0;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	T = Integer.parseInt(st.nextToken());
    	
    	for(int i = 0;i < T; i++) {
    		st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		answer = 0;
    		arr = new int[N];
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<N;j++) {
    			arr[j] = Integer.parseInt(st.nextToken()); 
    		}
    		
    		long maxValue = 0;
    		for(int j=N-1; j>=0;j--) {
    			if(maxValue < arr[j]) {
    				maxValue = arr[j];
    			}else {
    				answer += maxValue - arr[j];
    			}
    		}
    		
    		System.out.println(answer);
    	}	
    }
    
}