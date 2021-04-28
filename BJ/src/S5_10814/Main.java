package S5_10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		String [] data = new String[201];

		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			if(data[age] == null) {
				data[age] = name;
			}
			else {
				data[age] = data[age] + " " + name;
			}
		}

		for(int i = 0; i <= 200; i++) {
			if(data[i] != null) {
				st = new StringTokenizer(data[i]);
				while(st.hasMoreTokens()) {
					System.out.println(i + " " + st.nextToken());
				}
			}
		}
	}
}
