package First_App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField TF1;
	private JPasswordField P1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 607, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Lb1 = new JLabel("Login Page\r\n\r\n");
		Lb1.setFont(new Font("Tahoma", Font.BOLD, 24));
		Lb1.setBounds(239, 11, 140, 73);
		frame.getContentPane().add(Lb1);
		
		JLabel Lb2 = new JLabel("Email\r\n");
		Lb2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		Lb2.setBounds(58, 114, 102, 20);
		frame.getContentPane().add(Lb2);
		
		JLabel Lb3 = new JLabel("Password\r\n");
		Lb3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		Lb3.setBounds(58, 200, 89, 14);
		frame.getContentPane().add(Lb3);
		
		TF1 = new JTextField();
		TF1.setBounds(225, 116, 173, 20);
		frame.getContentPane().add(TF1);
		TF1.setColumns(10);
		
		JButton BT1 = new JButton("Log In");
		BT1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				String a = TF1.getText();
				String b = P1.getText();
				
				if(a.equals("markpreetham252@gmail.com") && b.equals("abc"))
				{
				    JOptionPane.showMessageDialog(BT1, "Logged In Succesfully for "+a);
				}
				else
					JOptionPane.showMessageDialog(BT1, "Invalid Credentials");
			}
		});
		BT1.setBounds(263, 294, 89, 23);
		frame.getContentPane().add(BT1);
		
		P1 = new JPasswordField();
		P1.setBounds(225, 194, 173, 20);
		frame.getContentPane().add(P1);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
		
		
	}
}
