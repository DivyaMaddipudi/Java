
public class UIControl {
	private boolean isEnabled = true;
	
	
	public UIControl(boolean isEnabled) {
		System.out.println("UIControl");
	}

	public void disable() {
		isEnabled = false;
	}
	
	public boolean isEnabled() {
		return isEnabled;
	}

}
