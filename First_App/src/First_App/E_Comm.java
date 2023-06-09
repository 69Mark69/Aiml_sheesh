package First_App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class E_Comm {
	int b1=0;
	int b2=0;
	int b3=0;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					E_Comm window = new E_Comm();
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
	public E_Comm() {
		initialize();
	}
	
	public static int i=0;
	public static int y=0;
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 709, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lb1 = new JLabel("");
		lb1.setIcon(new ImageIcon("C:\\Users\\on linf\\Pictures\\logo.jpg"));
		lb1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lb1.setBounds(269, 22, 125, 58);
		frame.getContentPane().add(lb1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\on linf\\Desktop\\book1.PNG"));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(34, 92, 113, 143);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\on linf\\Desktop\\book2.PNG"));
		lblNewLabel_1.setBounds(279, 91, 103, 143);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\on linf\\Desktop\\book3.PNG"));
		lblNewLabel_2.setBounds(523, 92, 114, 143);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("10 $");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(73, 246, 46, 22);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("9\r\n $");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(315, 245, 36, 20);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("13 $");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(548, 246, 46, 14);
		frame.getContentPane().add(lblNewLabel_3_2);
		
		JLabel lb2 = new JLabel("BILL : 0\r\n\r\n");
		lb2.setForeground(Color.WHITE);
		lb2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lb2.setBounds(537, 58, 100, 22);
		frame.getContentPane().add(lb2);
		
		JComboBox Cb = new JComboBox();
		Cb.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Cb.setBackground(Color.WHITE);
		Cb.setModel(new DefaultComboBoxModel(new String[] {"Select", "Paper", "PDF", "Book"}));
		Cb.setToolTipText("");
		Cb.setBounds(46, 277, 101, 22);
		frame.getContentPane().add(Cb);
		
		JComboBox Cb1 = new JComboBox();
		Cb1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Paper", "PDF", "Book"}));
		Cb1.setToolTipText("");
		Cb1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Cb1.setBackground(Color.WHITE);
		Cb1.setBounds(279, 277, 101, 22);
		frame.getContentPane().add(Cb1);
		
		JComboBox Cb2 = new JComboBox();
		Cb2.setModel(new DefaultComboBoxModel(new String[] {"Select", "Paper", "PDF", "Book"}));
		Cb2.setToolTipText("");
		Cb2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Cb2.setBackground(Color.WHITE);
		Cb2.setBounds(523, 277, 101, 22);
		frame.getContentPane().add(Cb2);
		
		JLabel LB = new JLabel("CART : 0\r\n\r\n");
		LB.setFont(new Font("Tahoma", Font.BOLD, 16));
		LB.setForeground(Color.WHITE);
		LB.setBounds(535, 36, 100, 22);
		frame.getContentPane().add(LB);
		
		JButton BT1 = new JButton("Add To Cart\r\n");
		BT1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String a=(String) Cb.getSelectedItem();
			     JOptionPane.showMessageDialog(BT1,"Selected:"+a);
			     i++;
			     LB.setText("CART :"+i);
			     y=y+10;
			     b1++;
			     lb2.setText("BILL :"+y);
			}
		});
		BT1.setBounds(46, 310, 101, 23);
		frame.getContentPane().add(BT1);
		
		JButton BT2 = new JButton("Add To Cart\r\n");
		BT2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String a=(String) Cb1.getSelectedItem();
			     JOptionPane.showMessageDialog(BT1,"Selected:"+a);
				 i++;
			     LB.setText("CART :"+i);
			     y=y+9;
			     b2++;
			     lb2.setText("BILL :"+y);
			}
		});
		BT2.setBounds(279, 310, 101, 23);
		frame.getContentPane().add(BT2);
		
		JButton BT3 = new JButton("Add To Cart\r\n");
		BT3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String a=(String) Cb2.getSelectedItem();
			     JOptionPane.showMessageDialog(BT1,"Selected:"+a);
			     i++;
			     LB.setText("CART :"+i);
			     y=y+13;
			     b3++;
			     lb2.setText("BILL :"+y);
			}
		});
		BT3.setBounds(523, 310, 101, 23);
		frame.getContentPane().add(BT3);
		
		JButton btnNewButton = new JButton("Remove\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i--;
				LB.setText("CART :"+i);
				y=y-10;
				b1--;
				lb2.setText("BILL :"+y);
			}
		});
		btnNewButton.setBounds(46, 344, 101, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i--;
				LB.setText("CART :"+i);
				y=y-9;
				b2--;
				lb2.setText("BILL :"+y);
			}
		});
		btnNewButton_1.setBounds(279, 344, 103, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remove\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i--;
				LB.setText("CART :"+i);
				y=y-13;
				b3--;
				lb2.setText("BILL :"+y);
			}
			
		});
		btnNewButton_2.setBounds(523, 344, 99, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton BT4 = new JButton("Proceed To Checkout\r\n");
		BT4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(BT4,"Total :"+y+"\n No of Books :"+i+"\n Book 1 : "+b1+"\n Book 2 : "+b2+"\n Book 3 : "+b3);
			}
		});
		BT4.setBounds(247, 409, 182, 23);
		frame.getContentPane().add(BT4);
		
		
	}
}
