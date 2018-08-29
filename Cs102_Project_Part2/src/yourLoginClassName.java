import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class yourLoginClassName extends JFrame {
	private Department department;
	private JPanel loginPanel;
	private JLabel emailLabel ;
	private JTextField mailText ;
	private JButton login ;
	
	public yourLoginClassName(Department department){
		super("login");
		this.department=department;
		loginPanel=new JPanel();
		this.add(loginPanel);
		emailLabel= new JLabel("Email: ");
		mailText = new JTextField(20);
		login = new JButton("Login");
		loginPanel.add(emailLabel);
		loginPanel.add(mailText);
		loginPanel.add(login);
		login.addActionListener(new LoginButtonHandler(mailText,department));
	}
		
}
