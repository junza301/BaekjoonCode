package S3_9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long [] pdb = new long[101];
		pdb[1] = 1;
		pdb[2] = 1;
		pdb[3] = 1;
		pdb[4] = 2;
		pdb[5] = 2;
		for(int i = 6; i <= 100; i++) {
			pdb[i] = pdb[i-1] + pdb[i-5];
		}
		
		int t = Integer.parseInt(bf.readLine());
		for(int i = 0 ; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());
			System.out.println(pdb[n]);
		}

	}

}
