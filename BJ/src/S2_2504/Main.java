package S2_2504;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int size = str.length();
		
		Stack<String> st = new Stack<>();

		int count = 0;
		for(int i = 0; i < size; i++) {
			String now = str.charAt(i)+"";
			if(now.equals(")")) {
				st.add(search(st, "(", "[", 2, count++));
			} else if(now.equals("]")) {
				st.add(search(st, "[", "(", 3, count++));			
			} else {
				st.add(now);
			}
		}
		
		int result = 0;
		while(!st.isEmpty()) {
			String now = st.pop();
			if(now.equals("(") || now.equals("[")) {
				System.out.println(0);
				System.exit(0);
			}
			result += Integer.parseInt(now);
		}
		System.out.println(result);
	}

	private static String search(Stack<String> st, String destination, String fail, int value, int count) {
		int result = 0;
		boolean check = false;
		
		while(!st.isEmpty()) {
			String tmp = st.pop();
			if(tmp.equals(fail)) {
				System.out.println(0);
				System.exit(0);
			}
			if(tmp.equals(destination)) {
				check = true;
				break;
			}
			result += Integer.parseInt(tmp);
		}

		
		if(!check) {
			System.out.println(0);
			System.exit(0);
		}

		if(result == 0)
			return value+"";
		else
			return (result*value)+"";
	}
}
