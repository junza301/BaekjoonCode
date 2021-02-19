package S3_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int [] stair = new int[n];
		for(int i = 0; i < n; i++)
			stair[i] = Integer.parseInt(bf.readLine());
		
		int now = n-1;
		int count = 1;
		int result = stair[n-1];
		while(now > 0) {
			if(now == 1) {
				if(count < 2) {
					result += stair[0];
				}
				break;
			}
			
			if(stair[now-1] >= stair[now-2] && count < 2) {
				result += stair[now-1];
				count++;
				now--;
			}
			else if(stair[now-1] < stair[now-2] || count == 2) {
				result += stair[now-2];
				count = 0;
				now -= 2;
			}
		}
		System.out.println(result);
	}
}
