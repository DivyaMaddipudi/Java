package abstract_clasas;

abstract class Graphic {
	protected int x1, y1;
	protected int x2, y2;
	
	public void setStart(int x, int y) {
		x1 = x;
		y1 = y;
	}
	
	public void setEnd(int x, int y) {
		x2 = x;
		y2 = y;
	}
	
	public abstract void draw();
}

class Line extends Graphic {
	
	@Override
	public void draw() {
		
		System.out.printf(" draw line from (%d, %d) to (%d, %d) %n", x1, y1, x2, y2);
	}
}

class Rectangle extends Graphic {

	@Override
	public void draw() {
		
		System.out.printf(" draw rectangle from (%d, %d) to (%d, %d) %n", x1, y1, x2, y2);
	}

	
}
public class Main {
	
	static void drawUtil (int x1, int y1, int x2, int y2, Graphic g) { 
		//base class object is declared above
		g.setStart(30, 40);
		g.setEnd(50, 60);
		g.draw();
		
	}

	public static void main(String[] args) {
		//drawUtil(10, 10, 20, 20, new Graphic());
		drawUtil(10, 50, 20, 80, new Line());
		drawUtil(10, 60, 20, 70, new Rectangle());
				
	}

}
