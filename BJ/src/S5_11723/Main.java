package S5_11723;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int m = Integer.parseInt(br.readLine());
		int [] s = new int[21];
		for(int i = 0; i < m; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);		
			String command = st.nextToken();
			if(command.equals("add")) {
				int tmp = Integer.parseInt(st.nextToken());
				s[tmp] = 1;
			}
			else if(command.equals("remove")) {
				int tmp = Integer.parseInt(st.nextToken());
				s[tmp] = 0;
			}
			else if(command.equals("check")) {
				int tmp = Integer.parseInt(st.nextToken());
				bw.write(s[tmp] + "\n");
			}
			else if(command.equals("toggle")) {
				int tmp = Integer.parseInt(st.nextToken());
				if(s[tmp] == 1)
					s[tmp] = 0;
				else
					s[tmp] = 1;
			}
			else if(command.equals("all")) {
				Arrays.fill(s, 1);
			}
			else if(command.equals("empty")) {
				Arrays.fill(s, 0);
			}
		}
		bw.flush();
		bw.close();
	}
}
