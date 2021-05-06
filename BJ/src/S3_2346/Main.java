package S3_2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		int [] data = new int[n+1];
		int [] result = new int[n];
		int result_idx = 0;
		
		st = new StringTokenizer(bf.readLine());
		for(int i = 1; i <= n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 1;
		int count = n-1;
		while(count != 0) {
			int move = data[idx];
			data[idx] = 0;
			result[result_idx++] = idx;
			
			while(move != 0) {
				if(move > 0) {
					idx++;
					if(idx > n)
						idx = 1;
					
					if(data[idx] == 0)
						continue;
					else
						move--;
				}
				else {
					idx--;
					if(idx == 0)
						idx = n;
					
					if(data[idx] == 0)
						continue;
					else
						move++;
				}
			}
			count--;
		}
		result[result_idx] = idx;
		
		for(int i = 0; i < n; i++) {
			System.out.print(result[i] + " ");
		}
	}

}
