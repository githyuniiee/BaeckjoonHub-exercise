import java.io.*;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int i=0; i<t; i++){
			String str = br.readLine().toLowerCase();
			int[] alpha = new int[26];
			int max = 0;

			for(int j=0; j<str.length(); j++){
				if(str.charAt(j) == ' ') continue;
				alpha[str.charAt(j) - 'a']++;
				max = Math.max(max, alpha[str.charAt(j) - 'a']);
			}

			
			int cnt = 0;
			char ch = ' ';
			for(int j=0; j<26; j++){
				if(max == alpha[j]){
					cnt++;
					ch = (char) (j + 'a');
				}

				if(cnt >= 2){
					ch = '?';
					break;
				}
			}
			System.out.println(ch);
		}
	

		
	}



}