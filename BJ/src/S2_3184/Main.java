package S2_3184;

import java.util.Scanner;

public class Main {
	static int r;
	static int c;
	static String [][] ground;
	static boolean [][] check;
	static int [] dirR = {-1, 0, 1, 0};
	static int [] dirC = {0, 1, 0, -1};
	static int nowS = 0;
	static int nowW = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		
		ground = new String[r][c];
		check = new boolean[r][c];
		
		int resultS = 0;
		int resultW = 0;
		
		for(int i = 0; i < r; i++) {
			String tmp = sc.next();
			for(int j = 0; j < c; j++) {
				ground[i][j] = tmp.charAt(j)+"";
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(!ground[i][j].equals("#") && check[i][j] == false) {
					DFS(i,j);
					if(nowS > nowW)
						resultS += nowS;
					else
						resultW += nowW;
					nowS = 0;
					nowW = 0;
				}
			}
		}
		
		System.out.println(resultS + " " + resultW);
	}

	private static void DFS(int i, int j) {
		check[i][j] = true;
		if(ground[i][j].equals("o"))
			nowS++;
		else if(ground[i][j].equals("v"))
			nowW++;
		for(int k = 0; k < 4; k++) {
			int nextR = i+dirR[k];
			int nextC = j+dirC[k];
			if(nextR >= 0 && nextR < r &&
				nextC >= 0 && nextC < c &&
				!ground[nextR][nextC].equals("#") &&
				check[nextR][nextC] == false)
			{
				DFS(nextR, nextC);
			}
		}
	}
}
