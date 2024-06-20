import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] one = new int[3];
        int[] two = new int[3];
        int[] result = new int[3];
        int x = 0;
        int y = 0;


        for (int i = 0; i < 6; i++) {
            if(i<3){
                one[i] = Integer.parseInt(st.nextToken());
            } else if (i == 3) {
                two[0] = Integer.parseInt(st.nextToken());
            } else if (i == 4) {
                two[1] = Integer.parseInt(st.nextToken());
            }else {
                two[2] = Integer.parseInt(st.nextToken());
            }
        }

        int[] one_2 = Arrays.copyOf(one, 3);
        int[] two_2 = Arrays.copyOf(two, 3);
        int[] one_3 = Arrays.copyOf(one, 3);
        int[] two_3 = Arrays.copyOf(two, 3);

        for (int i = 0; i < 3; i++) {
            one[i] *= two_2[0];
            two[i] *= one_2[0];
        }


        for (int i = 0; i < 3; i++) {
            result[i] = one[i] - two[i];
        }

        y = result[2] / result[1];




        for (int i = 0; i < 3; i++) {
            one_2[i] *= two_3[1];
            two_2[i] *= one_3[1];



        }

        for (int i = 0; i < 3; i++) {
            result[i] = one_2[i] - two_2[i];
        }

        x = result[2] / result[0];

        System.out.println(x + " " + y);


    }
}
