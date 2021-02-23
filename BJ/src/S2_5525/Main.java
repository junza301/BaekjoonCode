package S2_5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String s;
	static int m;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		m = Integer.parseInt(bf.readLine());
		s = bf.readLine();
		
		//최종 출력물
		int result = 0;
		
		// 처음 나오는 I를 찾기
		int tmp = Find_I(0);
		// 만약 I가 없다면 0을 출력하고 끝내기
		if(tmp == -1) {
			System.out.println(result);
			System.exit(0);
		}
		
		// 첫 I 다음 문자부터 시작
		int now = tmp+1;
		// OI를 셀 변수
		int count = 0;
		
		while(now < m-1) {
			// 현재 위치와 다음 위치 문자가 OI면 카운트 +1
			if(s.charAt(now) == 'O' && s.charAt(now+1) == 'I') {
				count++;
				// 카운트가 n이면 P(n)과 같은 형태가 됐다는 뜻
				if(count == n) {
					result++;
					count--;
				}
				now += 2;
			}
			else {
				// 현재 위치와 다음 위치 문자가 OI가 아니라면 현재 위치부터 처음 나오는 I를 검색
				count = 0;
				tmp = Find_I(now);
				if(tmp == -1) {
					System.out.println(result);
					System.exit(0);
				}
				// 첫 I 다음 문자부터 다시 시작
				now = tmp+1;
			}
		}
		
		System.out.println(result);
	}

	private static int Find_I(int i) {
		while(s.charAt(i) == 'O') {
			i++;
			if(i == m)
				return -1;
		}

		return i;
	}	
}
