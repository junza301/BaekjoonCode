package S3_2630;

import java.util.Scanner;

public class Main {
	
	static int [][] grid;
	static int white = 0;
	static int blue = 0;
	static int tmp = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		grid = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
			
		spl(0, n-1, 0, n-1);
		System.out.println(white);
		System.out.println(blue);
	}
	
	public static void spl(int Xstart, int Xend, int Ystart, int Yend) {
		boolean check = true;
		int color = grid[Xstart][Ystart];
		for(int i = Xstart; i<=Xend; i++) {
			for(int j = Ystart; j<=Yend; j++) {
				if(color != grid[i][j]) {
					check = false;
					break;
				}
			}
			if(check == false)
				break;
		}
		
		if(check == true) {
			if(color == 0)
				white++;
			else
				blue++;
		}
		else {
			spl(Xstart, (Xend-Xstart)/2 + Xstart, Ystart, (Yend-Ystart)/2 + Ystart);
			spl((Xend-Xstart)/2 + Xstart + 1, Xend, Ystart, (Yend-Ystart)/2 + Ystart);
			spl(Xstart, (Xend-Xstart)/2 + Xstart, (Yend-Ystart)/2 + Ystart+1, Yend);
			spl((Xend-Xstart)/2 + Xstart + 1, Xend, (Yend-Ystart)/2 + Ystart+1, Yend);
		}
	}
}
