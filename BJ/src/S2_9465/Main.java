package S2_9465;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int [] result = new int[t];
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int [][] sticker = new int[2][n];
			for(int j = 0; j < 2; j++) {
				for(int k = 0; k<n; k++) {
					sticker[j][k] = sc.nextInt();
				}
			}
			
			int [][] DP = new int[2][n];
			DP[0][0] = sticker[0][0];
			DP[1][0] = sticker[1][0];
			DP[0][1] = DP[1][0] + sticker[0][1];
			DP[1][1] = DP[0][0] + sticker[1][1];
			for(int a = 2; a < n; a++) {
				DP[0][a] = sticker[0][a] + MAX(DP[0][a-2], DP[1][a-2], DP[1][a-1]);
				DP[1][a] = sticker[1][a] + MAX(DP[1][a-2], DP[0][a-2], DP[0][a-1]);
			}
			
			int tmp = DP[0][n-2];
			int tmp2 = MAX(DP[1][n-2], DP[0][n-1], DP[1][n-1]);
			if(tmp2 > tmp)
				tmp = tmp2;
			result[i] = tmp;
		}
		for(int i = 0; i<t; i++)
			System.out.println(result[i]);
	}

	private static int MAX(int i, int j, int k) {
		int max = i;
		if(j>max)
			max = j;
		if(k>max)
			max = k;
		return max;
	}

}
