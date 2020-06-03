import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.List;
import java.util.Map.Entry;

class Employee {
	private String name;
	private String no;
	
	public Employee(String name, String no) {
		super();
		this.name = name;
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	
}
public class Map {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		s = s + sc.nextLine();
		
		String[] p = s.split(" ");
		
		int i = sc.nextInt();
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		
		System.out.println(s);
		System.out.println(i);
		for(int i1=0;i1<p.length;i1++) {
			System.out.println(p[i1].toUpperCase());
		}
		/*for(int i =0; i<4;i++) {
			int a = sc.nextInt();
			String b = sc.next();
			hm.put(a, b);
		}*/
		
		
		//for(Entry<Integer, String> m:hm.entrySet()) {
			//System.out.println(m.getKey() + m.getValue());
		//}
	}
}
