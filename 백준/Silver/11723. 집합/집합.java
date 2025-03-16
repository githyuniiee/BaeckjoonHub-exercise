import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<n; i++){
			
			String str = br.readLine();

			if(str.contains("add")){
				String[] strArr = str.split(" ");
				set.add(strArr[1]);

			}else if(str.contains("remove")){
				String[] strArr = str.split(" ");
				set.remove(strArr[1]);

			}else if(str.contains("check")){
				String[] strArr = str.split(" ");
				if(set.contains(strArr[1])){
					sb.append(1).append("\n");
				}else{
					sb.append(0).append("\n");
				}

			}else if(str.contains("toggle")){
				String[] strArr = str.split(" ");
				if(!set.contains(strArr[1])){
					set.add(strArr[1]);
				}else{
					set.remove(strArr[1]);
				}

			}else if(str.contains("all")){
				set.clear();
				
				for(int j=1; j<=20; j++){
					set.add(String.valueOf(j));
				}

			}else{
				set.clear();
			}

		}

		System.out.println(sb);

		

    }
}