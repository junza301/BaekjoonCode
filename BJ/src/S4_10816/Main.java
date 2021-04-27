package S4_10816;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		st = new StringTokenizer(bf.readLine());
		
		for(int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(map.containsKey(tmp)) {
				int count = map.get(tmp);
				map.put(tmp, ++count);
			}
			else {
				map.put(tmp, 1);
			}
		}
		
		int m = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < m; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(map.containsKey(tmp)) {
				bw.write(map.get(tmp) + " ");
			}
			else {
				bw.write("0 ");
			}
		}
		bw.flush();
		bw.close();
	}
}
