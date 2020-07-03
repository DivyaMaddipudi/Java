
public class UIControl {
	protected boolean isEnabled = true;
	
	public UIControl(boolean isEnabled) {
		this.isEnabled = isEnabled;
		System.out.println("UIControl");
	}
	public void disable() {
		isEnabled = false;
	}
	public boolean isEnabled() {
		return isEnabled;
	}

}
