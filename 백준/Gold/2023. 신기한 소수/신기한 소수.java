import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;

    public static boolean isPrime(int num){

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0){
                return false; //소수 아님
            }
        }

        return true; //소수 임

    }

    public static void dfs(int num, int jarisu) {

        if (jarisu == n) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }

            if (isPrime(num * 10 + i)) {
                dfs(num * 10 + i, jarisu + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        //일의 자리 소수 2,3,5,7 4개 수
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

    }
}





