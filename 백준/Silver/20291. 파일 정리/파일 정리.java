import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();

		for(int i=0; i<n; i++){
			String str = br.readLine();
			int idx = str.indexOf('.');
			str = str.substring(idx + 1, str.length());
			map.put(str, map.getOrDefault(str, 0) + 1);
		}

		List<String> list = new ArrayList<>();

		for(String s : map.keySet()){
			list.add(s);
		}

		Collections.sort(list);

		for(String s : list){
			System.out.println(s + " " + map.get(s));
		}

	}



}