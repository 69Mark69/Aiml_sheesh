package First_App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reg {

	private JFrame frame;
	private JTextField TF1;
	private JTextField TF2;
	private JTextField TF3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reg window = new Reg();
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
	public Reg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JLabel Lb1 = new JLabel("Registration\r\n");
		Lb1.setFont(new Font("Tahoma", Font.BOLD, 20));
		Lb1.setForeground(Color.RED);
		Lb1.setBounds(267, 31, 124, 32);
		frame.getContentPane().add(Lb1);
		
		JLabel lb2 = new JLabel("Name");
		lb2.setForeground(Color.RED);
		lb2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb2.setBounds(80, 111, 124, 32);
		frame.getContentPane().add(lb2);
		
		JLabel lb3 = new JLabel("Roll No.");
		lb3.setForeground(Color.RED);
		lb3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb3.setBounds(80, 183, 124, 32);
		frame.getContentPane().add(lb3);
		
		JLabel lb4 = new JLabel("Email\r\n");
		lb4.setForeground(Color.RED);
		lb4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb4.setBounds(80, 251, 124, 32);
		frame.getContentPane().add(lb4);
		
		TF1 = new JTextField();
		TF1.setBounds(233, 111, 186, 20);
		frame.getContentPane().add(TF1);
		TF1.setColumns(10);
		
		TF2 = new JTextField();
		TF2.setColumns(10);
		TF2.setBounds(233, 193, 186, 20);
		frame.getContentPane().add(TF2);
		
		TF3 = new JTextField();
		TF3.setColumns(10);
		TF3.setBounds(233, 251, 186, 20);
		frame.getContentPane().add(TF3);
		
		/**
		String a=TF1.getText();
		String b=TF2.getText();
		String c=TF3.getText();
		 */
		
		
		
		
		JButton BT1 = new JButton("Submit\r\n");
		BT1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l = new Login();
				l.setVisible(true);
				frame.setVisible(false);
			}
		});
	
		BT1.setBounds(288, 328, 89, 23);
		frame.getContentPane().add(BT1);
		frame.setBackground(Color.BLACK);
		frame.setBounds(100, 100, 689, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(false);
	}
}
