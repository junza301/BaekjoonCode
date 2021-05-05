package S3_3036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		
		st = new StringTokenizer(bf.readLine());
		int first = Integer.parseInt(st.nextToken());
		for(int i = 1; i < n; i++) {
			int operand = Integer.parseInt(st.nextToken());
			int GCD = ucle(Math.max(first, operand), Math.min(first,  operand));
			System.out.println(first/GCD + "/" + operand/GCD);
		}			
	}

	private static int ucle(int first, int operand) {
		while(operand != 0) {
			int tmp = first % operand;
			first = operand;
			operand = tmp;
		}
		return first;
	}
}
