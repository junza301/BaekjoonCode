package S3_2257_fail;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		Stack<Character> stack = new Stack<>();
		int h=0, c=0, o=0;

		for(int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			int now = x-'0';
			if(now >= 2 && now <= 9) {
				char prev = stack.pop();
				if(prev == ')') {
					ArrayList<Character> tmp = new ArrayList<>();
					while(stack.peek() != '(') {
						tmp.add(stack.pop());
					}
					stack.pop();
					for(int j =0; j < now; j++) {
						for(int k = 0; k < tmp.size(); k++) {
							stack.add(tmp.get(k));
						}	
					}
				} else {
					for(int j = 0; j < now; j++) {
						stack.add(prev);
					}
				}
			}else {
				stack.add(x);
			}	
		}
		int size = stack.size();
		for(int i = 0; i < size; i++) {
			char now = stack.pop();
			switch(now) {
			case 'C' : c++; break;
			case 'H' : h++; break;
			case 'O' : o++; break;
			}		
		}
		
		int result = h + (c*12) + (o*16);
		System.out.println(result);
	}
}
