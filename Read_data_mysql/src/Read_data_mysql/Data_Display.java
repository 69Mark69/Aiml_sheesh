package Read_data_mysql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Data_Display {

	private JFrame frame;
	private JTable Table;
	private JTextField TF1;
	private JLabel lblMarks;
	private JTextField TF2;
	private JScrollPane scrollPane;
	private JTextField TF3;
	private JLabel lb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Data_Display window = new Data_Display();
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
	public Data_Display() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 699, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(323, 35, 332, 257);
		frame.getContentPane().add(scrollPane);
		
		Table = new JTable();
		scrollPane.setViewportView(Table);
		Table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(31, 114, 73, 49);
		frame.getContentPane().add(lblNewLabel);
		
		TF1 = new JTextField();
		TF1.setBounds(126, 132, 137, 20);
		frame.getContentPane().add(TF1);
		TF1.setColumns(10);
		
		lblMarks = new JLabel("Marks");
		lblMarks.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMarks.setBounds(31, 164, 73, 49);
		frame.getContentPane().add(lblMarks);
		
		TF2 = new JTextField();
		TF2.setColumns(10);
		TF2.setBounds(126, 182, 137, 20);
		frame.getContentPane().add(TF2);
		
		JButton B1 = new JButton("Submit");
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=TF1.getText();
				int b=Integer.parseInt(TF2.getText());
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aiml?useSSL=false","root","mrec");
					Statement sta=con.createStatement();
					String q = "insert into student values('"+a+"','"+b+"')";
					sta.execute(q);
					con.close();
					JOptionPane.showMessageDialog(B1,"Data Sent");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		B1.setFont(new Font("Tahoma", Font.BOLD, 12));
		B1.setForeground(Color.BLACK);
		B1.setBounds(126, 303, 89, 23);
		frame.getContentPane().add(B1);
		
		JButton B2 = new JButton("Load");
		B2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aiml?useSSL=false","root","mrec");
					String q="Select * from student";
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(q);
					ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model =(DefaultTableModel) Table.getModel();
					int col=rsmd.getColumnCount();
					String[] colName=new String[col];
					for(int i=0;i<=col;i++)
					{
						colName[i]=rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colName);
						String n1,m1;
						while(rs.next())
						{
							n1=rs.getString(1);
							m1=rs.getString(2);
							String row[]= {n1,m1};
							model.addRow(row);
						}
						con.close();
					}
		
					
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		B2.setFont(new Font("Tahoma", Font.BOLD, 12));
		B2.setBounds(365, 303, 89, 23);
		frame.getContentPane().add(B2);
		
		JButton B3 = new JButton("Clear");
		B3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.setModel(new DefaultTableModel());
				
			}
		});
		B3.setFont(new Font("Tahoma", Font.BOLD, 12));
		B3.setBounds(544, 303, 89, 23);
		frame.getContentPane().add(B3);
		
		JLabel lblMarks_1 = new JLabel("Check");
		lblMarks_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMarks_1.setBounds(31, 227, 73, 49);
		frame.getContentPane().add(lblMarks_1);
		
		TF3 = new JTextField();
		TF3.setColumns(10);
		TF3.setBounds(126, 245, 137, 20);
		frame.getContentPane().add(TF3);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=TF3.getText();
				String b="";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aiml?useSSl=false","root","mrec");
					Statement stb=con.createStatement();
					String s="Select name from student where marks =?";
					PreparedStatement ps=con.prepareStatement(s);
					ps.setString(1, a);
					ResultSet rs1=ps.executeQuery();
					ResultSetMetaData rsmd1=rs1.getMetaData();
					DefaultTableModel model =(DefaultTableModel) Table.getModel();
					int col=rsmd1.getColumnCount();
					String[] colName=new String[col];
					for(int i=0;i<=col;i++)
					{
						colName[i]=rsmd1.getColumnName(i+1);
						model.setColumnIdentifiers(colName);
						String n1;
						while(rs1.next())
						{
							n1=rs1.getString(1);
							b+=(n1+" ");
							lb.setText(b);
							String row[]= {n1};
							model.addRow(row);
						}
						con.close();
					}
					
					
					
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(455, 303, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		lb = new JLabel("");
		lb.setBackground(Color.WHITE);
		lb.setBounds(31, 361, 232, 80);
		frame.getContentPane().add(lb);
		
		JButton b5 = new JButton("Check_new");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String a="";
					int b;
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aiml?useSSL=false","root","mrec");
					Statement sta =con.createStatement();
					String q = "Select name , marks from student";
					ResultSet rs = sta.executeQuery(q);
					while(rs.next())
					{
						a=rs.getString(1);
						b=rs.getInt(2);
					}
					
					
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		b5.setBounds(455, 338, 89, 23);
		frame.getContentPane().add(b5);
	}
}
