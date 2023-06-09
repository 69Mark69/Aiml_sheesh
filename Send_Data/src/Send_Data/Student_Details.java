package Send_Data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Student_Details {

	private JFrame frame;
	private JTextField TF1;
	private JTextField TF2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Details window = new Student_Details();
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
	public Student_Details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 731, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Details");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(215, 34, 216, 82);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("S.No\r\n");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(62, 151, 61, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name\r\n");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(62, 238, 61, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		TF1 = new JTextField();
		TF1.setBounds(215, 156, 216, 20);
		frame.getContentPane().add(TF1);
		TF1.setColumns(10);
		
		TF2 = new JTextField();
		TF2.setBounds(215, 232, 216, 20);
		frame.getContentPane().add(TF2);
		TF2.setColumns(10);
		
		JButton BT1 = new JButton("Enter");
		BT1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a =TF1.getText();
				int sno=Integer.parseInt(a);
				String b =TF2.getText();
				
				try {
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/aiml?useSSL=false ","root","mrec");
					String q="insert into student values('"+sno+"','"+b+"')";
					Statement sta=con.createStatement();
					sta.execute(q);
					con.close();
					JOptionPane.showMessageDialog(BT1,"Registration Successfull");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		BT1.setBounds(272, 336, 89, 23);
		frame.getContentPane().add(BT1);
	}

}
