package S2_1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		int [][] grid = new int[n][n];
		long [][] dp = new long[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < n; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 0)
					continue;
				if(i+grid[i][j] < n)
					dp[i+grid[i][j]][j] += dp[i][j];
				if(j+grid[i][j] < n)
					dp[i][j+grid[i][j]] += dp[i][j];
			}
		}
		
		System.out.println(dp[n-1][n-1]);
	}
}
