package S5_11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		Coordi [] co = new Coordi[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			co[i] = new Coordi(x,y);
		}
		
		Arrays.sort(co, new Comparator<Coordi>() {
			public int compare(Coordi o1, Coordi o2) {
				if(o1.x != o2.x) {
					return o1.x - o2.x;
				}
				else {
					return o1.y - o2.y;
				}
			}
		});
		
		for(Coordi c : co) {
			System.out.println(c.x + " " + c.y);
		}
	}
	
	public static class Coordi {
		int x;
		int y;
		
		public Coordi(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
