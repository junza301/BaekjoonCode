package S2_4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int num = 123456*2;
		boolean [] arr = new boolean[num+1];
		for(int i = 0; i <= num; i++)
			arr[i] = true;
		arr[0] = false;
		arr[1] = false;
		
		for(int i = 2; i*i <= num; i++) {
			if(arr[i] == false)
				continue;
			
			for(int j = i+i; j<=num; j+=i)
				arr[j] = false;
		}
		
		while(true) {
			int now = Integer.parseInt(bf.readLine());
			if(now == 0)
				System.exit(0);
			
			int count = 0;
			for(int i = now+1; i <= 2*now; i++) {
				if(arr[i] == true)
					count++;
			}
			System.out.println(count);
		}
	}
}
