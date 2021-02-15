package S5_2609;

import java.util.Scanner;

public class Main {
	public static Factor x1 = new Factor();
	public static Factor y1 = new Factor();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		Spl(x, x1);
		Spl(y, y1);
		
		int result = 1;
		
		int i = 0, j = 0;
		while(true) {
			if(i == x1.num || j == y1.num)
				break;
			
			if(x1.factor[i] > y1.factor[j]) {
				j++;
			}
			else if(x1.factor[i] < y1.factor[j]) {
				i++;
			}
			else {
				int times = Math.min(x1.count[i], y1.count[j]);
				for(int z = 0; z < times; z++)
					result *= x1.factor[i];
				i++;
				j++;
			}
		}
		
		System.out.println(result);
		System.out.println(x*y/result);
	}
	
	public static void Spl(int a, Factor b) {
		while(a != 1) {
			int i;
			for(i = 2; i <= a; i++) {
				if(a%i == 0) {
					int index = b.find(i);	
					if(index == -1) {
						b.factor[b.num] = i;
						b.count[b.num]++;
						b.num++;
						break;
					}
					else {
						b.count[index]++;
						break;
					}
				}
			}
			a /= i;
		}
	}
	
	public static class Factor {
		int [] factor = new int[100];
		int [] count = new int[100];
		int num = 0;
		
		public int find(int k) {
			for(int i = 0; i<num; i++) {
				if(factor[i]==k)
					return i;
			}		
			return -1;
		}
	}

}
