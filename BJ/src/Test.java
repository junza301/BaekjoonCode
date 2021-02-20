import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		Queue<Integer> q = new LinkedList<>();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int [] check = new int[n+1];
		int [] num = new int[n+1];
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			str = bf.readLine();
			st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for(int j = 0; j < graph.get(1).size(); j++) {
			q.add(graph.get(1).get(j));
		}
		
		System.out.println(q.poll());
		System.out.println(q.poll());
	}

}
