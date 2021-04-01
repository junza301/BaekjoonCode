package G5_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int count = 0;
	static int [] col;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		
		col = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			col[1] = i;
			dfs(1);
		}
		
		System.out.println(count);
	}

	private static void dfs(int row) {
		if(row == n)
			count++;
		else {
			for(int i = 1; i <= n; i++) {
				col[row+1] = i;
				if(isPossible(row+1)) {
					dfs(row+1);
				}
			}
		}
	}

	private static boolean isPossible(int c) {
		for(int i = 1; i < c; i++) {
			if(col[i] == col[c]) {
				return false;
			}
			
			if(Math.abs(col[i] - col[c]) == Math.abs(i - c)) {
				return false;
			}
		}
		return true;
	}

}
