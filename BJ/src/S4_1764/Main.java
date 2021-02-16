package S4_1764;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String [] hear = new String[n];
		String [] see = new String[m];
		
		
		String [] result = new String[Math.max(n,m)]; // 같은 문자열이 들어갈 배열
		int count = 0; // 같은 문자열의 개수
		
		for(int i = 0; i < n; i++)
			hear[i] = sc.next();
		for(int i = 0; i < m; i++)
			see[i] = sc.next();
		
		// 정렬
		Arrays.sort(hear);
		Arrays.sort(see);
		
		// i는 hear 배열의 현재위치. j는 see 배열의 현재위치.
		int i = 0, j = 0;
		
		// 문자열이 같다면 result 배열에 저장 후 현재위치를 모두 증가시키기.
		// 문자열이 다르다면 사전순으로 작은쪽의 현재 위치를 증가시키기.
		while(i != n && j != m) {
			if(hear[i].compareTo(see[j]) > 0) {
				j++;
			}
			else if(hear[i].compareTo(see[j]) < 0) {
				i++;
			}
			else {
				result[count++] = hear[i];
				i++;
				j++;
			}
		}
		
		// 출력
		System.out.println(count);
		for(i = 0; i < count; i++)
			System.out.println(result[i]);
	}

}
