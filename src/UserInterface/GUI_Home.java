package UserInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;

public class GUI_Home extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					GUI_Account frame = new GUI_Account();
//					frame.setVisible(true);
					GUI_Home frame = new GUI_Home();
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
	public GUI_Home() {
		setBackground(Color.WHITE);
		setTitle("Trang chủ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1021, 557);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Danh mục");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Nhân viên");
		mntmNewMenuItem.setIcon(new ImageIcon("D:\\Java\\Project\\Image\\kisspng-clerk-computer-icons-clip-art-clerk-5b20ba415e19a0.6115672115288714893854-removebg-preview.png"));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Khách hàng");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Home frame = new GUI_Home();
				frame.setVisible(false);
				GUI_Customer frame1 = new GUI_Customer();
				frame1.setVisible(true);
				
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon("D:\\Java\\Project\\Image\\noavatar.png"));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Linh kiện");
		mntmNewMenuItem_2.setIcon(new ImageIcon("D:\\Java\\Project\\Image\\tải xuống.png"));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("Hóa đơn");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Hóa đơn bán");
		mntmNewMenuItem_6.setIcon(new ImageIcon("D:\\Java\\Project\\Image\\pngtree-invoice-icon-png-image_1817550-removebg-preview.png"));
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_4 = new JMenu("Tài khoản");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Tạo tài khoản");
		mntmNewMenuItem_4.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_4.setIcon(new ImageIcon("D:\\Java\\Project\\Image\\icon30.png"));
		mnNewMenu_4.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Đăng xuất");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Account account = new GUI_Account();
				account.setVisible(true);
				GUI_Home frame = new GUI_Home();
				frame.setVisible(false);
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon("D:\\Java\\Project\\Image\\logouticon.png"));
		mnNewMenu_4.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("Trợ giúp");
		menuBar.add(mnNewMenu_1);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Java\\Project\\Image\\Phần mềm quản lý cửa hàng linh kiện điện tử (1).png"));
		lblNewLabel.setBounds(10, 0, 987, 488);
		getContentPane().add(lblNewLabel);
	}
}
