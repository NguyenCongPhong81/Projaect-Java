package UserInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;









public class Process_Customer {
	Connect con = new Connect();
	public ArrayList<Customer> getListCustomer() {
		// TODO Auto-generated method stub
		Connection cn = con.getCon();
		String sql = "select * from tb_customer";
		ArrayList<Customer> lsscustomer = new ArrayList<>();
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer ct = new Customer();
				ct.setMaKH(rs.getString("MaKH"));
				ct.setName(rs.getString("Name"));
				ct.setAge(rs.getInt("Age"));
				ct.setNumberPhone(rs.getInt("NumberPhone"));
				ct.setAddress(rs.getString("Address"));
				lsscustomer.add(ct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsscustomer;
	}
	public boolean insertCustomer(String MaKH, String Name, int Age, int NumberPhone, String Address) {
		Connection cn = con.getCon();
		String sql= "insert into tb_customer (MaKH, Name,  Age, NumberPhone, Address)  values (?,?,?,?,?) ";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1,MaKH);
			ps.setString(2,Name);
			ps.setInt(3,Age);
			ps.setInt(4, NumberPhone);
			ps.setString(5,Address);
			ps.executeUpdate();
			cn.close();
			return true;
		}catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}
		public boolean updateCustomer(String MaKH, String Name, int Age, int NumberPhone, String Address) {
			Connection cn = con.getCon();
			int rs=0;
			String sql = "update tb_customer set  Name=?, Age=?, NumberPhone=?, Address = ? where MaKH=?";
			ArrayList<Customer> lsscusomer = new ArrayList<>();
			try {
				PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
				ps.setString(1, Name);
				ps.setInt(2, Age);
				ps.setInt(3, NumberPhone);
				ps.setString(4, Address);
				ps.setString(5, MaKH);
				rs = ps.executeUpdate();
				
			} catch (SQLException e) {
				return false;
			}
			return (rs==1) ? true : false;
			
			// TODO Auto-generated method stub
		}
		public boolean delCustomer(String MaKH) {
			// TODO Auto-generated method stub
			Connection cn = con.getCon();
			int rs=0;
			String sql = "delete from tb_customer where MaKH=?";
			ArrayList<Customer> lssCustomer = new ArrayList<>();
			try {
				PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
				ps.setString(1, MaKH);
				rs = ps.executeUpdate();
				
			} catch (SQLException e) {
				return false;
			}
			return (rs==1) ? true : false;
		}
		public ArrayList<Customer> getCustomer_byMaKH(String MaKH) {
			// TODO Auto-generated method stub
			Connection cn = con.getCon();
			String sql = "select * from tb_customer where MaKH=? ";
			ArrayList<Customer> lsstudent = new ArrayList<>();
			try {
				PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
				ps.setString(1, MaKH);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Customer st = new Customer();
					st.setMaKH(rs.getString("MaKH"));
					st.setName(rs.getString("Name"));
					st.setAge(rs.getInt("Age"));
					st.setNumberPhone(rs.getInt("NumberPhone"));
					st.setAddress(rs.getString("Address"));
					lsstudent.add(st);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return lsstudent;
		}
	 

}
