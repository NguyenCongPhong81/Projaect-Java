package UserInterface;

public class Datail {
	private String User, Password;

	public Datail() {
		super();
	}

	public Datail(String user, String password) {
		super();
		User = user;
		Password = password;
	}

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
}
