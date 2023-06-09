import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UserSignUp {

	JFrame frame;
	private JTextField fname;
	private JTextField lname;
	private JTextField username;
	private JTextField email;
	private JTextField phoneNo;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSignUp window = new UserSignUp();
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
	public UserSignUp() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	 public static boolean isValid(String email)
	    {
	        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
	                            "[a-zA-Z0-9_+&*-]+)*@" +
	                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
	                            "A-Z]{2,7}$";
	                              
	        Pattern p = Pattern.compile(emailRegex);

	        return p.matcher(email).matches();
	    }

	 public static boolean onlyDigits(String s)
	    {
	       
	        for (int i = 0; i < s.length(); i++) 
	        {

	            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') return true;
	            
	            else  return false;
	        }
	        return false;
	    }
	 
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(0, 0, 205));
		frame.getContentPane().setLayout(null);

		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 32, 387, 41);
		frame.getContentPane().add(lblNewLabel);
		
		fname = new JTextField();
		fname.setBounds(77, 71, 250, 34);
		frame.getContentPane().add(fname);
		fname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 116, 387, 41);
		frame.getContentPane().add(lblNewLabel_1);
		
		lname = new JTextField();
		lname.setBounds(77, 153, 250, 34);
		frame.getContentPane().add(lname);
		lname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 361, 387, 34);
		frame.getContentPane().add(lblNewLabel_2);
		
		username = new JTextField();
		username.setBounds(77, 395, 250, 34);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("e - mail");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(10, 198, 387, 34);
		frame.getContentPane().add(lblNewLabel_3);
		
		email = new JTextField();
		email.setBounds(77, 229, 250, 34);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Phone number");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 274, 387, 34);
		frame.getContentPane().add(lblNewLabel_4);
		
		phoneNo = new JTextField();
		phoneNo.setBounds(77, 305, 250, 34);
		frame.getContentPane().add(phoneNo);
		phoneNo.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(10, 427, 387, 41);
		frame.getContentPane().add(lblNewLabel_5);
		
		pass = new JTextField();
		pass.setBounds(77, 466, 250, 34);
		frame.getContentPane().add(pass);
		pass.setColumns(10);
		frame.setBounds(100, 100, 424, 670);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new UserChoose().frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(255, 140, 0));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(316, 592, 81, 31);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String u = username.getText();
					String p = pass.getText();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testme","root","root");
					Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/testme","root","root");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/testme","root","root");
					Statement s = con.createStatement();
					Statement s1 = con1.createStatement();
					Statement s2 = con2.createStatement();
					String query1 = "insert into UserSignUp(fname,lname,email,phoneNo,username,password) values ('"+fname.getText()+"' , '"+lname.getText()+"' , '"+email.getText()+"', '"+phoneNo.getText()+"','"+u+"', '"+p+"')";						
					String query2 = "insert into UserLogIn(username,password,fname,lname) values ('"+u+"', '"+p+"', '"+fname.getText()+"','"+lname.getText()+"')";
					String query3 = "insert into contesters(fname,lname) values ('"+fname.getText()+"','"+lname.getText()+"')";
					if(fname.getText().trim().isEmpty() || lname.getText().trim().isEmpty() || email.getText().trim().isEmpty() || phoneNo.getText().trim().isEmpty() || username.getText().trim().isEmpty() || pass.getText().trim().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Please fill all the fields!");
					}
									
					else if(fname.getText().matches(".*\\d.*")) JOptionPane.showMessageDialog(null, "First name must contain letters only!");
					else if(lname.getText().matches(".*\\d.*")) JOptionPane.showMessageDialog(null, "Last name must contain letters only!!");
					else if(!isValid(email.getText())) JOptionPane.showMessageDialog(null, "Invalid email format!");
					else if(!phoneNo.getText().matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Invalid Phone Number!");
					else if(username.getText().matches("[0-9]+")) JOptionPane.showMessageDialog(null, "Username must not contain numbers only!");
					else 
					{				 
					 s.execute(query1);
					 s1.execute(query2);
					 s2.execute(query3);
					 new UserChoose().frame.setVisible(true);
					 frame.dispose();
					 JOptionPane.showMessageDialog(null, "Signed up!");
					}
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(255, 140, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(149, 527, 105, 41);
		frame.getContentPane().add(btnNewButton);

		 frame.setLocationRelativeTo(null);

	}
}
