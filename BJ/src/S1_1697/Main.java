package S1_1697;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int k;
	static boolean [] check = new boolean[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		k = sc.nextInt();
		
		// 동생 위치가 0일때 예외처리
		if(k == 0) {
			System.out.println(n);
			System.exit(0);
		}
		
		Arrays.fill(check, false);
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		check[n] = true;
		
		BFS(q);
	}

	private static void BFS(Queue<Integer> q) {
		int time = 0;
		while(!q.isEmpty()) {
			int Qsize = q.size();
			for(int i = 0; i < Qsize; i++) {
				int tmp = q.poll();
				if(tmp == k) {
					System.out.println(time);
					System.exit(0);
				}
				
				if(tmp*2 <= 100000 && tmp*2 > 0 && check[tmp*2] == false) {
					q.add(tmp*2);
					check[tmp*2] = true;
				}
				if(tmp+1 <= 100000 && check[tmp+1] == false) {
					q.add(tmp+1);
					check[tmp+1] = true;
				}
				if(tmp-1 > 0 && check[tmp-1] == false) {
					q.add(tmp-1);
					check[tmp-1] = true;
				}
			}
			time++;
		}	
	}
}
