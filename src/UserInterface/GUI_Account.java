package UserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.Panel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Canvas;
import javax.swing.Box;
import javax.swing.JSlider;
import java.awt.Label;

public class GUI_Account extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel JLabel;
	
	Connect con = new Connect();
    private PreparedStatement pst = null;  
    private ResultSet rs = null;
//	public void Login() {
//        setResizable(false);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//   
//        con.getCon();
//    }
	
	
	private boolean checktext() {
		boolean kq = true;
		if(this.textField.getText().length()==0) {
			JLabel.setText("User Name null");
			return false;
		}
		if(String.valueOf(this.passwordField.getPassword()).length()==0) {
			JLabel.setText("Password null");
			return false;
		}
		return kq;
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Account frame = new GUI_Account();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_Account() {
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên Đăng Nhập");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(41, 122, 146, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(83, 203, 91, 31);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(239, 122, 303, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.setSelectedIcon(null);
		btnNewButton.setIcon(null);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(141, 287, 131, 40);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(239, 206, 305, 31);
		contentPane.add(passwordField);
		
		JButton btnRefresh = new JButton("Làm mới");
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRefresh.setBounds(373, 287, 131, 40);
		contentPane.add(btnRefresh);
		
		Label label = new Label("");
		label.setFont(new Font("Dialog", Font.PLAIN, 18));
		label.setBounds(141, 364, 363, 21);
		contentPane.add(label);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
				label.setText("");
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "SELECT * FROM tb_account WHERE Name = ? and Password = ? ";
				Connection con = Connect.getCon();
				if(checktext()) 
					try {
						PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			            ps.setString(1, textField.getText());
			            ps.setString(2, String.valueOf(passwordField.getPassword()));
			            ResultSet rs = ps.executeQuery();
			            if(rs.next()){
			            	Datail dt = new Datail();
							dt.setUser(rs.getString("Name"));
							dt.setPassword(rs.getString("Password"));
			                if(rs.getString("Name").trim().toString().equals("Admin")){
			                    GUI_Home home = new GUI_Home();
			                    setVisible(false);
			                    home.setVisible(true);
			                }
			                else{
//			                    HomeUser home=new HomeUser(detail);
//			                    this.setVisible(false);
//			                    home.setVisible(true);
			                }
			            }
			            else{
			                label.setText("Wrong username or password!");
			                label.setForeground(Color.red);	            }
						
					}catch(Exception ex){
			            ex.printStackTrace();
			        }
				} 
				
				
			
		});
	}
}
