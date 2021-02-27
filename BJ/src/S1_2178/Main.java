package S1_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		//입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//미로 배열과 방문확인 배열
		int [][] maze = new int[n][m];
		boolean [][] check = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			str = bf.readLine();
			for(int j = 0; j < m; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}
		
		//BFS 큐. x좌표와 y좌표를 차례로 넣어준다.
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		q.add(0);
		check[0][0] = true;
		
		//이동거리
		int count = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int z = 0; z < size/2; z++) {
				int i = q.poll();
				int j = q.poll();
				if(i == n-1 && j == m-1) {
					System.out.println(count+1);
					System.exit(0);
				}
				
				//네 방향을 결정해주는 dir 배열
				int [][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
				
				
				for(int a = 0; a < 4; a++) {
					int tmpi = i + dir[a][0];
					int tmpj = j + dir[a][1];
					
					//좌표가 미로 안에 존재하고, 방문되지 않았으며, 갈 수 있는 길일 때
					if(tmpi >= 0 && tmpi < n && tmpj >= 0 && tmpj < m && !check[tmpi][tmpj] && maze[tmpi][tmpj] == 1) {
						q.add(tmpi);
						q.add(tmpj);
						
						//BFS는 큐에 넣자마자 check 해주지않으면 메모리가 초과될 수 있다.
						check[tmpi][tmpj] = true;
					}
				}
			}
			count++;
		}
	}
}
