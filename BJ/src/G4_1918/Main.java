package G4_1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		
		Stack<Character> s = new Stack<>();
	
		for(int i = 0; i < str.length(); i++) {
			char X = str.charAt(i);
			if(X >= 'A' && X <= 'Z')
				System.out.print(X);
			else if(X == '(')
				s.add(X);
			else if(X == ')') {
				char now = s.pop();
				while(now!='(') {
					System.out.print(now);
					now = s.pop();
				}
			}
			else {
				if(s.isEmpty())
					s.add(X);
				else {
					int nowP = Priority(X);
					int prevP = Priority(s.peek());
					
					while(nowP <= prevP) {
						System.out.print(s.pop());
						if(s.isEmpty())
							break;
						prevP=Priority(s.peek());
					}
					s.add(X);
				}
			}	
		}
		
		while(!s.isEmpty())
			System.out.print(s.pop());
	}

	private static int Priority(char x) {
		if(x == '(')
			return 0;
		else if(x == '+' || x == '-')
			return 1;
		else
			return 2;
	}

}
