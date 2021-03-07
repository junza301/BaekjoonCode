package S2_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		
		int [] data = new int[n];
		int [] DP = new int[n];
		
		st = new StringTokenizer(bf.readLine());
		
		for(int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		DP[0] = 1;
		int max = 1;
		boolean check = false;
		
		for(int i = 1; i < n; i++) {
			int maxDPindex = -1;
			for(int j = i-1; j >= 0; j--) {
				if(data[i] > data[j]) {
					if(!check) {
						maxDPindex = j;
						check = true;
					}
					else {
						if(DP[j] > DP[maxDPindex])
							maxDPindex = j;
					}
				}
			}
			
			if(!check)
				DP[i] = 1;
			else {
				DP[i] = DP[maxDPindex]+1;
				if(DP[i] > max)
					max = DP[i];
			}
			
			check = false;
		}
		
		
		System.out.println(max);
	}
}
