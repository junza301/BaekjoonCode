package G4_2096;

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
		
		int [][] grid = new int[n][3];
		for(int i = 0; i < n; i++) {
			String str = bf.readLine();
			st = new StringTokenizer(str);
			grid[i][0] = Integer.parseInt(st.nextToken());
			grid[i][1] = Integer.parseInt(st.nextToken());
			grid[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int [][] DP = new int[n][3];
		DP[0][0] = grid[0][0];
		DP[0][1] = grid[0][1];
		DP[0][2] = grid[0][2];
		
		for(int i = 1; i < n; i++) {
			DP[i][0] = grid[i][0] + Math.max(DP[i-1][0], DP[i-1][1]);
			DP[i][1] = grid[i][1] + max(DP[i-1][0], DP[i-1][1], DP[i-1][2]);
			DP[i][2] = grid[i][2] + Math.max(DP[i-1][1], DP[i-1][2]);
		}
		int Max = max(DP[n-1][0], DP[n-1][1], DP[n-1][2]);
		
		for(int i = 0 ; i < n; i++)
			Arrays.fill(DP[i], 0);
		DP[0][0] = grid[0][0];
		DP[0][1] = grid[0][1];
		DP[0][2] = grid[0][2];
		
		for(int i = 1; i < n; i++) {
			DP[i][0] = grid[i][0] + Math.min(DP[i-1][0], DP[i-1][1]);
			DP[i][1] = grid[i][1] + min(DP[i-1][0], DP[i-1][1], DP[i-1][2]);
			DP[i][2] = grid[i][2] + Math.min(DP[i-1][1], DP[i-1][2]);
		}
		int Min = min(DP[n-1][0], DP[n-1][1], DP[n-1][2]);
		
		System.out.println(Max + " " + Min);
	}

	private static int min(int i, int j, int k) {
		int Min = i;
		if(Min > j)
			Min = j;
		if(Min > k)
			Min = k;
		return Min;
	}

	private static int max(int i, int j, int k) {
		int Max = i;
		if(Max<j)
			Max = j;
		if(Max<k)
			Max = k;
		return Max;
	}
}
