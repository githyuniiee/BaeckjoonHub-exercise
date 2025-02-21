import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n,r,c;
    static int count = 0;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        z((int)Math.pow(2,n), 0, 0);
        
    }

    static void z(int size, int x, int y){
        if(r == x && y == c){
            System.out.println(count);
            return;
        }

        if(x <= r && y <= c && r < x + size && c < y + size){
            int newSize = size / 2;

            z(newSize, x,y); //1사분면
            z(newSize, x, y + newSize); //2사분면
            z(newSize, x + newSize, y); //3사분면
            z(newSize, x + newSize, y + newSize); //4사분면
        }else{
            count += size*size;
        }
    }

    

}
