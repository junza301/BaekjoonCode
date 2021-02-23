package S2_5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String s;
	static int m;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//�Է�
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		m = Integer.parseInt(bf.readLine());
		s = bf.readLine();
		
		//���� ��¹�
		int result = 0;
		
		// ó�� ������ I�� ã��
		int tmp = Find_I(0);
		// ���� I�� ���ٸ� 0�� ����ϰ� ������
		if(tmp == -1) {
			System.out.println(result);
			System.exit(0);
		}
		
		// ù I ���� ���ں��� ����
		int now = tmp+1;
		// OI�� �� ����
		int count = 0;
		
		while(now < m-1) {
			// ���� ��ġ�� ���� ��ġ ���ڰ� OI�� ī��Ʈ +1
			if(s.charAt(now) == 'O' && s.charAt(now+1) == 'I') {
				count++;
				// ī��Ʈ�� n�̸� P(n)�� ���� ���°� �ƴٴ� ��
				if(count == n) {
					result++;
					count--;
				}
				now += 2;
			}
			else {
				// ���� ��ġ�� ���� ��ġ ���ڰ� OI�� �ƴ϶�� ���� ��ġ���� ó�� ������ I�� �˻�
				count = 0;
				tmp = Find_I(now);
				if(tmp == -1) {
					System.out.println(result);
					System.exit(0);
				}
				// ù I ���� ���ں��� �ٽ� ����
				now = tmp+1;
			}
		}
		
		System.out.println(result);
	}

	private static int Find_I(int i) {
		while(s.charAt(i) == 'O') {
			i++;
			if(i == m)
				return -1;
		}

		return i;
	}	
}
