import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoginButtonHandler implements ActionListener {
	private JTextField textf;
	private Department department;
		
		public LoginButtonHandler(JTextField textf, Department department){
			this.textf=textf;
			this.department=department;
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton){
			JButton button1= (JButton)e.getSource();
			boolean isInstructorExist= false;
			for(int k=0;k<department.getInstructors().size();k++){
				if(department.getInstructors().get(k).getEmail().equals(textf.getText())){
					isInstructorExist=true;
					 InstructorFrame instructorUser = new InstructorFrame(department.getInstructors().get(k));
				}
		
				
			}
			if(isInstructorExist==false){
				JOptionPane.showMessageDialog(null,"The instructur with the email is not exist!");
				}
		}
		
	}

}
