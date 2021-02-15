package B2_1193;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int parent = 1, child = 1;
		boolean column = true, row = true;
		while(x!=1) {
			if(child == 1 && row == true) {
				parent++;
				row = false;
				x--;
				continue;
			}
			else if(parent == 1 && column == true) {
				child++;
				column = false;
				x--;
				continue;
			}
			
			if(column == true && row == false) {
				x--;
				child++;
				parent--;
				if(parent == 1)
					row = true;
			}
			else if(column == false && row == true) {
				x--;
				child--;
				parent++;
				if(child == 1)
					column = true;
			}
		}
		
		System.out.println(child + "/" + parent);
	}

}
