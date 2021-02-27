package S4_17219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = bf.readLine();
		st = new StringTokenizer(str);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			str = bf.readLine();
			st = new StringTokenizer(str);
			String a = st.nextToken();
			String b = st.nextToken();
			
			map.put(a, b);
		}
		
		for(int i = 0; i < m; i++) {
			str = bf.readLine();
			System.out.println(map.get(str));
		}
	}
}
