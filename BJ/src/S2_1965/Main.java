package S2_1965;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		int [] data = new int[n];
		int [] dp = new int[n];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
	
		for(int i = 1; i < n; i++) {
			for(int j = i-1; j >= 0; j--) {
				if(data[i] > data[j] && dp[j] >= dp[i]) {
					dp[i] = dp[j]+1;
				}
			}
		}
		
		Arrays.sort(dp);
		System.out.println(dp[n-1]);
	}

}
