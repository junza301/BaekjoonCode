package S4_1120;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		
		int result = Integer.MAX_VALUE;
		for(int i = 0; i <= b.length()-a.length(); i++) {
			int tmp = 0;
			for(int j = 0; j < a.length(); j++) {
				if(a.charAt(j) != b.charAt(i+j))
					tmp++;
			}
			result = Math.min(result, tmp);
		}
		System.out.println(result);
	}
}
