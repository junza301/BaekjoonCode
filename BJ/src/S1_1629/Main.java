package S1_1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		System.out.println(Divide(a,b,c));
	}

	private static long Divide(int a, int b, int c) {
		if(b == 1) {
			return a % c;
		}
		else {
			long tmp = Divide(a, b/2, c);
			if(b % 2 == 0) {
				return ((tmp%c) * (tmp%c)) % c;
			}
			else {
				return ((tmp%c * tmp%c) * (a%c)) % c;
			}
		}
	}
}
