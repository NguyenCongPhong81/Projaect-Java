package UserInterface;

public class Customer {
	private String MaKH, Name, Address ;
	private int Age,NumberPhone;
	
	public Customer() {
		super();
	}
	public Customer(String maKH, String name, String address, int age, int numberPhone) {
		super();
		MaKH = maKH;
		Name = name;
		Address = address;
		Age = age;
		NumberPhone = numberPhone;
	}
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getNumberPhone() {
		return NumberPhone;
	}
	public void setNumberPhone(int numberPhone) {
		NumberPhone = numberPhone;
	}
}
