package S4_1620;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		HashMap<String, Integer> Pokemon = new HashMap<String, Integer>();
		String [] Name = new String[n];
		for(int i = 0; i<n; i++) {
			String tmp = sc.next();
			Pokemon.put(tmp, i);
			Name[i] = tmp;
		}
		
		
		for(int i = 0; i<m; i++) {
			String tmp = sc.next();
			if(tmp.charAt(0) >= '0' && tmp.charAt(0) <= '9') {
				System.out.println(Name[Integer.parseInt(tmp)-1]);
			}
			else {
				System.out.println(Pokemon.get(tmp)+1);
			}
		}
	}

}
