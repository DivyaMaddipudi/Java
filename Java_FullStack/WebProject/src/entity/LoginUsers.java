package entity;

public class LoginUsers {
	
	private int users_id;
	private String name;
	private String email;
	private String password;
	
	public LoginUsers(int users_id, String name, String email, String password) {
		super();
		this.users_id = users_id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public LoginUsers(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	

	public LoginUsers(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
