import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class UserCategoryChoose {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserCategoryChoose window = new UserCategoryChoose();
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
	public UserCategoryChoose() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 205));
		frame.setBounds(100, 100, 759, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		
		JButton social = new JButton("Social ");
		social.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new UserSocialCategory().frame.setVisible(true);
				frame.dispose();
			}
		});
		social.setFont(new Font("Tahoma", Font.PLAIN, 20));
		social.setForeground(new Color(255, 255, 255));
		social.setBackground(new Color(255, 140, 0));
		social.setBounds(262, 202, 214, 71);
		frame.getContentPane().add(social);
		
		JButton science = new JButton("Science");
		science.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new UserScienceCategory().frame.setVisible(true);
				frame.dispose();
				
			}
		});
		science.setForeground(new Color(255, 255, 255));
		science.setFont(new Font("Tahoma", Font.PLAIN, 20));
		science.setBackground(new Color(255, 140, 0));
		science.setBounds(262, 316, 214, 71);
		frame.getContentPane().add(science);
		
		JButton btnNewButton_2 = new JButton("Sign Out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new UserChoose().frame.setVisible(true);
				frame.dispose();
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(255, 140, 0));
		btnNewButton_2.setBounds(629, 465, 104, 38);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Categories");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblNewLabel.setBounds(43, 35, 663, 102);
		frame.getContentPane().add(lblNewLabel);
	}
}
