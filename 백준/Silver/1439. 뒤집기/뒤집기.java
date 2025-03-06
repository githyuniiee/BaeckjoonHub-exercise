import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int zerCnt = 0;
        int oneCnt = 0;

        char ch = str.charAt(0);

        if(ch == '1'){
            oneCnt++;
        }else{zerCnt++;}

        for(int i=1; i<str.length(); i++){
            
            if(str.charAt(i) == ch){
                continue;
            }
            
            ch = str.charAt(i);
            if(ch == '1'){
                oneCnt++;
            }else{
                zerCnt++;
            }
        }

        System.out.println(Math.min(zerCnt, oneCnt));
        
       
    }
}