package S3_11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int [] data = new int[n];
		
		st = new StringTokenizer(bf.readLine());
		data[0] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i < n; i++) {
			data[i] = data[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			
			if(start == 0) {
				System.out.println(data[end]);
			}
			else {
				System.out.println(data[end] - data[start-1]);
			}
		}
	}
}
