package Send_Data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class LogIn {

	private JFrame frame;
	private JTextField TF1;
	private JPasswordField TF2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 416, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log In\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(142, 27, 92, 86);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(45, 160, 103, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password :\r\n");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(45, 244, 103, 33);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		TF1 = new JTextField();
		TF1.setBounds(180, 170, 154, 20);
		frame.getContentPane().add(TF1);
		TF1.setColumns(10);
		
		TF2 = new JPasswordField();
		TF2.setBounds(180, 254, 154, 20);
		frame.getContentPane().add(TF2);
		
		JButton B1 = new JButton("Log In");
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=TF1.getText();
				String b=TF2.getText();
				
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aiml?useSSL=false","root","mrec");
					String q="select count(*) from signup where username=? and password =?";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setString(1,a);
					ps.setString(2,b);
					ResultSet rs=ps.executeQuery();
					rs.next();
					int c=rs.getInt(1);
					if(c==0)
					{
						JOptionPane.showMessageDialog(B1,"Invalid Choice");
					}
					else
					{
						JOptionPane.showMessageDialog(B1, "Logged In Successfully");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		B1.setBounds(142, 346, 89, 23);
		frame.getContentPane().add(B1);
	}

}
