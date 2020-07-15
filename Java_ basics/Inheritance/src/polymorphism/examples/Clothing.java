package polymorphism.examples;

public class Clothing {
	private int id = 1;
	private String desc;
	private double price;
	
	public Clothing(String desc, double price) {
		setId(id);
		setDesc(desc);
		setPrice(price);
	}
	
	public void display() {
		System.out.println("Item id is:" + getId());
		System.out.println("Item desc is:" + getDesc());
		System.out.println("Item price is:" + getPrice());
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id++;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
