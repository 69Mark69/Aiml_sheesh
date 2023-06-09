package Send_Data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class Sign_Up {

	private JFrame frame;
	private JTextField TF1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPasswordField TF2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign_Up window = new Sign_Up();
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
	public Sign_Up() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 421, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Set Username :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(31, 159, 150, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSetPassword = new JLabel("Set Password :");
		lblSetPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSetPassword.setBounds(31, 220, 150, 41);
		frame.getContentPane().add(lblSetPassword);
		
		TF1 = new JTextField();
		TF1.setBounds(187, 173, 162, 20);
		frame.getContentPane().add(TF1);
		TF1.setColumns(10);
		
		JButton Bt1 = new JButton("Sign Up\r\n");
		Bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a= TF1.getText();
				String b= TF2.getText();
				try {
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/aiml?useSSL=false","root","mrec");
					String q="insert into signup values('"+a+"','"+b+"')";
					Statement sta= con.createStatement();
					sta.execute(q);
					con.close();
					JOptionPane.showMessageDialog(Bt1, "Created an Account Successfully");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		Bt1.setBounds(169, 311, 89, 23);
		frame.getContentPane().add(Bt1);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\on linf\\Pictures\\snip.jpg"));
		lblNewLabel_1.setBounds(50, 28, 100, 79);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Sign Up");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_2.setBounds(187, 28, 211, 85);
		frame.getContentPane().add(lblNewLabel_2);
		
		TF2 = new JPasswordField();
		TF2.setBounds(191, 234, 158, 20);
		frame.getContentPane().add(TF2);
	}
}
