import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Map;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        HashMap<String, String> animal = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            str = br.readLine();
            String[] sounds = str.split(" ");

            while(true){
                String word = br.readLine();

                String[] wordTokens = word.split(" ");

                if (!wordTokens[1].equals("goes")) {
                    break;
                }else{
                    animal.put(wordTokens[0], wordTokens[2]);
                }
            }

            for (int j = 0; j < sounds.length; j++) {
                if (!animal.containsValue(sounds[j])) {
                    System.out.print(sounds[j] + " ");
                }
            }
            System.out.println();


        }
    }
}