package S4_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < n; i++) {
			boolean check = true;
			Stack<Character> st = new Stack<>();
			String str = bf.readLine();
			
			for(int j = 0; j < str.length(); j++) {
				char tmp = str.charAt(j);
				if(tmp == '(')
					st.push(tmp);
				else {
					if(st.isEmpty()) {
						System.out.println("NO");
						check = false;
						break;
					}
					else {
						st.pop();
					}
				}	
			}
			if(!check)
				continue;
			
			if(st.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
