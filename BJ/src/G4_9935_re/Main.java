package G4_9935_re;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String bomb = sc.next();
		
		Stack<Character> st = new Stack<>();

		for(int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			st.add(now);
			
			if(now == bomb.charAt(bomb.length()-1)) {

				boolean check = search(st, bomb);
				if(check)
					boom(st, bomb);
			}
		}
		
		if(st.isEmpty())
			System.out.println("FRULA");
		else {
			StringBuilder sb = new StringBuilder();
			while (!st.isEmpty()) {
				sb.append(st.pop());
			}
			sb.reverse();
			System.out.println(sb.toString());
		}
	}

	private static boolean search(Stack<Character> st, String bomb) {
		if(st.size()>=bomb.length()) {
			for(int i = 0; i < bomb.length(); i++) {
				if(st.get(st.size()-1-i) != bomb.charAt(bomb.length()-1-i))
					return false;
			}
			return true;
		} else
			return false;
	}

	private static void boom(Stack<Character> st, String bomb) {
		for(int i = 0; i < bomb.length(); i++) {
			st.pop();
		}
	}
}