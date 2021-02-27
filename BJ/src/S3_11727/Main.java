package S3_11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int [] data = new int[1001];
		data[1] = 1;
		data[2] = 3;
		for(int i = 3; i <= n; i++) {
			data[i] = (data[i-1] + data[i-2]*2) % 10007;
		}
		System.out.println(data[n]);
	}
}
