package S2_5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(bf.readLine());
		for(int k = 0; k < t; k++) {
			String command = bf.readLine();
			int length = Integer.parseInt(bf.readLine());
			String num = bf.readLine();
			
			int [] arr = new int[length];
			int [] arr_r = new int[length];
			
			if(length != 0) {
				String numEx = num.substring(1, num.length()-1);
				st = new StringTokenizer(numEx, ",");
				int i = 0;
				while(st.hasMoreTokens()) {
					arr[i++] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < arr.length; i++) {
				arr_r[i] = arr[arr.length-1-i];
			}
			
			boolean Error = false;
			boolean reverse = false;
			int startIndex = 0;
			int endIndex = length - 1;
			int R_startIndex = 0;
			int R_endIndex = length - 1;
			
			for(int i = 0; i < command.length(); i++) {
				if(command.charAt(i) == 'R') {
					if(reverse)
						reverse = false;
					else
						reverse = true;
				}
				else {
					if(startIndex > endIndex) {
						System.out.println("error");
						Error = true;
						break;
					}
					
					if(reverse) {
						endIndex--;
						R_startIndex++;
					}
					else {
						startIndex++;
						R_endIndex--;
					}
				}
			}
			
			if(Error)
				continue;
			
			if(startIndex > endIndex || length == 0) {
				System.out.println("[]");
				continue;
			}
			
			String result;
			if(reverse) {
				int [] tmp = Arrays.copyOfRange(arr_r, R_startIndex, R_endIndex+1);
				result = Arrays.toString(tmp).replace(" ", "");	
			}
			else {
				int [] tmp = Arrays.copyOfRange(arr, startIndex, endIndex+1);
				result = Arrays.toString(tmp).replace(" ", "");		
			}
			System.out.println(result);
		}
	}
}
