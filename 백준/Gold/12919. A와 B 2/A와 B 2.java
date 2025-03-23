import java.io.*;

public class Main {

    static String s, t;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();

		dfs(t);
		System.out.println(answer);

    }

	static void dfs(String t){

		int lenT = t.length();

		if(lenT == s.length()){
			if(t.equals(s)){
				answer = 1;
			}
			return;
		}

		if(t.endsWith("A")){
			dfs(t.substring(0, lenT - 1));
		}

		if(t.startsWith("B")){
			dfs(new StringBuilder(t.substring(1)).reverse().toString());
		}
	}

}
