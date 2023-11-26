package janina;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Book_Shop {

	private JFrame frame;
	private JTextField bname;
	private JTextField bedition;
	private JTextField bprice;
	private JTextField bid;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book_Shop window = new Book_Shop();
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
	public Book_Shop() {
		initialize();
		Connect();
		
	}
	
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	 public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root","");
	        }
	        catch (ClassNotFoundException ex) 
	        {
	          ex.printStackTrace();
	        }
	        catch (SQLException ex) 
	        {
	               ex.printStackTrace();
	        }

	    }
	 
	 
	 
//	 public void table_load()
//	 {
//	     try 
//	     {
//	     pst = con.prepareStatement("select * from book");
//	     rs = pst.executeQuery();
//	     table.setModel(DbUtils.resultSetToTableModel(rs));
//	 } 
//	     catch (SQLException e) 
//	      {
//	         e.printStackTrace();
//	   } 
//	 }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 399);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANAGEMENT");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel.setBounds(139, 1, 281, 48);
		frame.getContentPane().add(lblNewLabel);
		
		bname = new JTextField();
		bname.setBounds(101, 80, 131, 20);
		frame.getContentPane().add(bname);
		bname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 83, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Edition");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(20, 122, 71, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		bedition = new JTextField();
		bedition.setColumns(10);
		bedition.setBounds(101, 119, 131, 20);
		frame.getContentPane().add(bedition);
		
		JLabel lblNewLabel_1_2 = new JLabel("Price");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(20, 165, 71, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		bprice = new JTextField();
		bprice.setColumns(10);
		bprice.setBounds(101, 162, 131, 20);
		frame.getContentPane().add(bprice);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				            
				    String bookname,edition,price;
				    bookname = bname.getText();
				    edition = bedition.getText();
				    price = bprice.getText();
				                
				     try {
				        pst = con.prepareStatement("insert into book(name,edition,price)values(?,?,?)");
				        pst.setString(1, bookname);
				        pst.setString(2, edition);
				        pst.setString(3, price);
				        pst.executeUpdate();
				        JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
				        // table_load();
				                       
				        bname.setText("");
				        bedition.setText("");
				        bprice.setText("");
				        bname.requestFocus();
				       }

				    catch (SQLException e1) 
				        {            
				       e1.printStackTrace();
				    }
				}
				
				
				
			
			
		});
		btnNewButton.setBounds(10, 193, 96, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnClear = new JButton("CLEAR\r\n");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				bname.setText("");
		        bedition.setText("");
		        bprice.setText("");
		        bname.requestFocus();
			}
		});
		btnClear.setBounds(136, 193, 96, 34);
		frame.getContentPane().add(btnClear);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(o);
			}
		});
		btnExit.setBounds(74, 238, 96, 34);
		frame.getContentPane().add(btnExit);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 283, 211, 66);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Book ID");
		lblNewLabel_1_3.setBounds(10, 24, 76, 19);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_3);
		
		bid = new JTextField();
		bid.setBounds(75, 25, 105, 20);
		panel.add(bid);
		bid.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(311, 60, 251, 209);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(324, 290, 96, 34);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(455, 290, 96, 34);
		frame.getContentPane().add(btnDelete);
	}
}
