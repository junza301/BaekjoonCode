package S2_7562;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int [] dirX = {-1,1,2,2,1,-1,-2,-2};
	static int [] dirY = {-2,-2,-1,1,2,2,1,-1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int k = 0; k < t; k++) {
			int n = sc.nextInt();
			int startY = sc.nextInt();
			int startX = sc.nextInt();
			int desY = sc.nextInt();
			int desX = sc.nextInt();
			
			int count = 0;
			boolean check = false;
			int [][] visited = new int[n][n];
			
			Queue<ArrayList> q = new LinkedList<>();
			ArrayList<Integer> start = new ArrayList<>();
			start.add(startX);
			start.add(startY);
			q.add(start);
			visited[startX][startY] = 1;
				
			while(!q.isEmpty()) {
				int size = q.size();
				for(int i = 0; i < size; i++) {
					ArrayList now = q.poll();
					int nowX = (int)now.get(0);
					int nowY = (int)now.get(1);
					if(nowX == desX && nowY == desY) {
						check = true;
						break;
					}

					
					for(int j = 0; j < 8; j++) {
						int tmpX = nowX + dirX[j];
						int tmpY = nowY + dirY[j];
						if(tmpX >= 0 && tmpX < n &&
							tmpY >= 0 && tmpY < n &&
							visited[tmpX][tmpY] == 0) {
							ArrayList<Integer> tmp = new ArrayList<>();
							tmp.add(tmpX);
							tmp.add(tmpY);
							q.add(tmp);
							visited[tmpX][tmpY] = 1;
						}
					}
					
				}
				
				if(check)
					break;
				count++;
			}
			
			if(!check)
				count = 0;
			System.out.println(count);
		}
	}
}
