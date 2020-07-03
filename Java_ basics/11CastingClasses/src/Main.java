
public class Main {
	public static void main(String[] args) {
		var control = new UIControl(true); 
		var textBox = new TextBox();
		
		show(control);
	}
	
	public static void show(UIControl control) {
		//var textBox = (TextBox) control; // Down Casting
		
		if(control instanceof TextBox) {
			var textBox = (TextBox) control;
			textBox.setText("Hello World");
		}
		System.out.println(control);
		
	}
	
}
