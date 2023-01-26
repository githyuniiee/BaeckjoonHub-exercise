import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  
   
   public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	   StringBuilder sb = new StringBuilder();
	   int T;
	   int alpha = 26; 
	   
	   T = Integer.parseInt(br.readLine());
	   
        for(int t=0; t<T; t++){
            String line = br.readLine();
            int sum = 0;
            boolean[] isIn = new boolean[alpha];
            
            for(int n=0; n<line.length(); n++){
                isIn[line.charAt(n) - 'A'] = true;
            }
            
            for(int i=0; i<alpha; i++){
                if(!isIn[i]){
                    sum+= i+'A';
                }
            }
            sb.append(sum).append("\n");
        }
       System.out.println(sb);
    }
}