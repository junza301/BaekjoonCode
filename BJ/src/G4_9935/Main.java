package G4_9935;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String bomb = sc.next();
		
		Stack<Character> st = new Stack<>();
		String target = "";
		for(int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			st.add(now);
			
			if(now == bomb.charAt(target.length())) {
				target += now;
				if(target.length() == bomb.length()) {
					boom(st, bomb);
					target = search(st, bomb);
				}
			} else if (now == bomb.charAt(0)) {
				target=now+"";
				if(target.length() == bomb.length()) {
					boom(st, bomb);
					target = search(st, bomb);
				}
			} else {
				target = "";
			}
		}
		
		if(st.isEmpty())
			System.out.println("FRULA");
		else {
			String result = "";
			while(!st.isEmpty()) {
				result = st.pop() + result;
			}
			System.out.println(result);
		}
	}

	private static void boom(Stack<Character> st, String bomb) {
		for(int i = 0; i < bomb.length(); i++) {
			st.pop();
		}
	}

	private static String search(Stack<Character> st, String bomb) {
		String tmp = "";
		boolean check = false;
		while(tmp.length() < bomb.length()-1 && !st.isEmpty()) {
			char now = st.pop();
			tmp = now + tmp;
			System.out.println(tmp);
			if(now == bomb.charAt(0)) {
				if(bomb.contains(tmp)) {
					check = true;
				}
				break;
			}
		}
		for(int i = 0; i < tmp.length(); i++)
			st.add(tmp.charAt(i));
		if(!check)
			tmp = "";
		return tmp;
	}
}
