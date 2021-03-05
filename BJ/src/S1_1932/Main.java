package S1_1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		int [][] grid = new int[501][501];
		int [][] result = new int[501][501];
		for(int i = 0; i < n; i++) {
			String str = bf.readLine();
			st = new StringTokenizer(str);
			int j = 0;
			while(st.hasMoreTokens()) {
				grid[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		
		result[0][0] = grid[0][0];
		result[1][0] = result[0][0] + grid[1][0];
		result[1][1] = result[0][0] + grid[1][1];
		
		for(int i = 2; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				if(j==0) {
					result[i][j] = grid[i][j] + result[i-1][j];
				}
				else if(j==i) {
					result[i][j] = grid[i][j] + result[i-1][j-1];
				}
				else {
					result[i][j] = Math.max(grid[i][j] + result[i-1][j-1], grid[i][j] + result[i-1][j]);
				}
			}
		}
		
		int max = result[n-1][0];
		for(int i = 1; i < n; i++) {
			if(max < result[n-1][i])
				max = result[n-1][i];
		}
		
		System.out.println(max);
	}
}
