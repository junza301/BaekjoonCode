package S1_1309;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int [] a = new int[n+1];
		int [] b = new int[n+1];
		int [] dp = new int[n+1];
		
		a[1] = 1;
		b[1] = 1;
		dp[1] = 3;
		
		for(int i = 2; i <= n; i++) {
			a[i] = (a[i-1] + (2 * b[i-1])) % 9901;
			b[i] = (a[i-1] + b[i-1]) % 9901;
			dp[i] = (a[i] + (2 * b[i])) % 9901;
		}
		System.out.println(dp[n]);
	}
}
