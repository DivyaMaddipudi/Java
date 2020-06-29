
public class Main {

	public static void main(String[] args) {
		
		//TextBox textBox1 = new TextBox();
					//or 
		var textBox1 = new TextBox();
		var textBox2 = textBox1;
		
		textBox2.setText("Hello");
		System.out.println(textBox1.text.toLowerCase());
		

	}

}
