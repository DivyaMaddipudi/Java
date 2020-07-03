
public class TextBox extends UIControl {
	private String text = "";
	
//	public TextBox() {
//		super(true);
//		//System.out.println("TextBox");
//	}
	
	
	@Override
	public String toString() {
		return text;
		
	}
	@Override
	public void render() {
		// TODO Auto-generated method stub
		System.out.println("Render text box");
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public void clear() {
		text = "";
	}
}
