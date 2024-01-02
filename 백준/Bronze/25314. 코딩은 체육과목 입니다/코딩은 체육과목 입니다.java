import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String str = "long ";

        if(num == 4){
            System.out.println("long int");
        }else{
            for(int i=0; i<num/4; i++){
                System.out.print(str);
            }
            System.out.print("int");
        }
    }
}