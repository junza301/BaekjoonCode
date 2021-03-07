package S1_6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(bf.readLine());
		for(int k = 0; k < t; k++) {
			st = new StringTokenizer(bf.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int LCM = getLCM(Math.max(m, n), Math.min(m, n));
			int xtmp = x;
			int ytmp = y;
			
			while(xtmp < LCM && ytmp < LCM) {
				if(xtmp == ytmp) {
					break;
				}
				else if(xtmp < ytmp) {
					xtmp += m;
				}
				else {
					ytmp += n;
				}
			}
			
			if(xtmp != ytmp)
				System.out.println("-1");
			else
				System.out.println(xtmp);
		}

	}

	private static int getLCM(int m, int n) {
		int x = m, y = n;
		
		while(n>0) {
			int tmp = m;
			m = n;
			n = tmp % n;
		}
		
		return (x*y)/m;
	}

}
