package S4_4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> st = new Stack<>();
		
		while(true) {
			String str = bf.readLine();
			if(str.equals("."))
				break;
			
			boolean check = true;
			for(int i = 0; i < str.length(); i++) {
				char tmp = str.charAt(i);
				
				if(tmp == '(') {
					st.add(tmp);
				}
				else if(tmp == '[') {
					st.add(tmp);
				}
				else if(tmp == ')') {
					if(!st.isEmpty() && st.peek() == '(') {
						st.pop();
					}
					else {
						check = false;
						break;
					}
				}
				else if(tmp == ']') {
					if(!st.isEmpty() && st.peek() == '[') {
						st.pop();
					}
					else {
						check = false;
						break;
					}
				}
				else
					continue;
			}
			
			if(!check) {
				System.out.println("no");
			}
			else {
				if(st.isEmpty())
					System.out.println("yes");
				else
					System.out.println("no");
			}
			st.clear();
		}
	}
}
