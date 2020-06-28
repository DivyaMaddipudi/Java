class Dog {

	private int id;
	private String name;

	public Dog(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {

		return String.format("%-4d: %s", id, name);

		/*
		StringBuilder sb = new StringBuilder();
		sb.append(id).append(": ").append(name);
		return sb.toString();
		 */
	}
}

public class App {

	public static void main(String[] args) {

		Dog d1 = new Dog(7, "roger");
		Dog d2 = new Dog(8, "roger");
		System.out.println(d1);
		System.out.println(d2);


	}

}
