import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		TreeMap<String, Integer> map = new TreeMap<>();

		for(int i=0; i<n; i++){
			String str = br.readLine();
			int idx = str.indexOf('.');
			str = str.substring(idx + 1, str.length());
			map.put(str, map.getOrDefault(str, 0) + 1);
		}

		for(String s : map.keySet()){
			System.out.println(s + " " + map.get(s));
		}

	}



}