package S1_1495;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();

		boolean [][] dp = new boolean[n+1][m+1];
		dp[0][s] = true;
		
		for(int i = 1; i<=n; i++) {
			int now = sc.nextInt();
			for(int j = 0; j <= m; j++) {
				if(dp[i-1][j] && j + now <= m) 
					dp[i][j+now] = true;
				if(dp[i-1][j] && j - now >= 0)
					dp[i][j-now] = true;
			}
		}
		
		for(int i = m; i >= 0; i--) {
			if(dp[n][i]) {
				System.out.println(i);
				System.exit(0);
			}
		}
		System.out.println(-1);
	}
}
