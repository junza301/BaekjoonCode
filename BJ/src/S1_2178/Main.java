package S1_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		//�Է�
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//�̷� �迭�� �湮Ȯ�� �迭
		int [][] maze = new int[n][m];
		boolean [][] check = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			str = bf.readLine();
			for(int j = 0; j < m; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}
		
		//BFS ť. x��ǥ�� y��ǥ�� ���ʷ� �־��ش�.
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		q.add(0);
		check[0][0] = true;
		
		//�̵��Ÿ�
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
				
				//�� ������ �������ִ� dir �迭
				int [][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
				
				
				for(int a = 0; a < 4; a++) {
					int tmpi = i + dir[a][0];
					int tmpj = j + dir[a][1];
					
					//��ǥ�� �̷� �ȿ� �����ϰ�, �湮���� �ʾ�����, �� �� �ִ� ���� ��
					if(tmpi >= 0 && tmpi < n && tmpj >= 0 && tmpj < m && !check[tmpi][tmpj] && maze[tmpi][tmpj] == 1) {
						q.add(tmpi);
						q.add(tmpj);
						
						//BFS�� ť�� ���ڸ��� check ������������ �޸𸮰� �ʰ��� �� �ִ�.
						check[tmpi][tmpj] = true;
					}
				}
			}
			count++;
		}
	}
}
