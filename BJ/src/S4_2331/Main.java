package S4_2331;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int p = sc.nextInt();

		boolean[] check = new boolean[1000000];
		int [] arr = new int[1000000];
		int arr_idx = 0;
		
		int now = a;
		arr[arr_idx++] = now;
		check[now] = true;
		
		while(true) {
			String tmp = now + "";
			now = 0;
			for(int i = 0; i < tmp.length(); i++) {
				char tmp_i = tmp.charAt(i);
				now += Math.pow(tmp_i - '0', p);
			}
			arr[arr_idx++] = now;
			if(check[now] == true)
				break;
			check[now] = true;
		}

		int count = 0;
		int idx = 0;
		while(arr[idx] != now) {
			count++;
			idx++;
		}	
		System.out.println(count);
	}
}
