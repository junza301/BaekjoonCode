package S2_1541;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		String Command = sc.next();
		
		//"-"로 스플릿 하기
		int [] Plus = new int[50];
		String [] Minus = Command.split("-");
		
		//나뉘어진 식을 각각 더하기
		for(int i = 0; i<Minus.length; i++) {
			String [] tmp = Minus[i].split("\\+");
			for(int j = 0; j<tmp.length; j++) {
				Plus[i] += Integer.parseInt(tmp[j]);
			}
		}
		
		//마이너스 연산 수행
		int result = 0;
		if(Plus.length > 0) {
			result = Plus[0];
			for(int i = 1; i < Plus.length; i++) {
				result -= Plus[i];
			}
		}
		System.out.println(result);
	}

}
