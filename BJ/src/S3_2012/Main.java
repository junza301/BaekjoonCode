package S3_2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			list.add(Integer.parseInt(bf.readLine()));
		}
		Collections.sort(list);
		
		long result = 0;
		int rank = 1;
		for(int i : list) {
			result += Math.abs(rank-i);
			rank++;
		}
		System.out.println(result);
	}
}
