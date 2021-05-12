package S2_1713;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int can_count, n;
	static Candi [] can;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		can = new Candi[n];
		can_count = 0;
		
		int m = sc.nextInt();
		for(int i = 0; i < m; i++) {
			int tmp = sc.nextInt();
			int idx = can_search(tmp);
			
			if(idx == -1) {
				if(can_count == n) {
					Arrays.sort(can, new Comparator<Candi>() {
						@Override
						public int compare(Candi o1, Candi o2) {
							if(o1.rec == o2.rec)
								return o2.life - o1.life;
							else
								return o1.rec - o2.rec;
						}	
					});
					can[0].num = tmp;
					can[0].rec = 1;
					can[0].life = 0;
				}
				else {
					can[can_count++] = new Candi(tmp);
				}
			}
			else {
				can[idx].rec++;
			}
			
			life_up();
		}
		
		Arrays.sort(can, new Comparator<Candi>() {
			@Override
			public int compare(Candi o1, Candi o2) {
				return o1.num - o2.num;
			}	
		});
		
		for(int i = 0; i < can_count; i++)
			System.out.print(can[i].num + " ");
	}
	
	private static int can_search(int tmp) {
		int idx = -1;
		for(int i = 0; i < can_count; i++) {
			if(can[i].num == tmp)
				idx = i;
		}
		return idx;
	}

	private static void life_up() {
		for(int i = 0; i < can_count; i++)
			can[i].life++;
		
	}

	public static class Candi {
		int num;
		int rec;
		int life;
		
		public Candi(int x) {
			this.num = x;
			this.rec = 1;
			this.life = 0;
		}
	}
}
