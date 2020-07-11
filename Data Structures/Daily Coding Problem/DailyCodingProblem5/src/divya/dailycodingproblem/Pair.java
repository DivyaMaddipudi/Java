package divya.dailycodingproblem;

public class Pair<U, V> {
	
	private U value1;
	private V value2;
	
	public Pair(U value1, V value2) {
		super();
		this.value1 = value1;
		this.value2 = value2;
	}
	
	
	
	public U getValue1() {
		return value1;
	}



	public void setValue1(U value1) {
		this.value1 = value1;
	}



	public V getValue2() {
		return value2;
	}



	public void setValue2(V value2) {
		this.value2 = value2;
	}



	@Override
	public String toString() {
		return "(" + value1 + ", " + value2 + ")";
	}



	public static <U, V>  Pair<U, V> of(U a, V b)
	{
		return new Pair<>(a, b);
	}

	
	
}
