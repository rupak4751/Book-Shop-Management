package janina;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class First extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					First frame = new First();
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
	public First() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(176, 11, 177, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblTo = new JLabel("TO");
		lblTo.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTo.setBounds(232, 52, 51, 43);
		contentPane.add(lblTo);
		
		JLabel lblBookHouse = new JLabel("BOOK HOUSE");
		lblBookHouse.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblBookHouse.setBounds(140, 90, 257, 43);
		contentPane.add(lblBookHouse);
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(215, 187, 104, 43);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Md Rupok\\Pictures\\Library-Management.jpg"));
		lblNewLabel_1.setBounds(0, 0, 537, 340);
		contentPane.add(lblNewLabel_1);
	}

}
