package S3_18111;

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
		int b = Integer.parseInt(st.nextToken());
		
		int [][] ground = new int[n][m];
		int min = 257, max = -1;
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < m; j++) {
				int next = Integer.parseInt(st.nextToken());
				ground[i][j] = next;
				
				if(next > max)
					max = next;
				if(next < min)
					min = next;
			}
		}
		
		int count = 0;
		
		while(max != min) {
			int maxcount = 0, mincount = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(ground[i][j] == max) maxcount++;
					if(ground[i][j] == min) mincount++;
				}
			}
			
			int height = max - min;
			int digtime = height * maxcount * 2;
			int stacktime = height * mincount;
			
			
		}
	}

}
