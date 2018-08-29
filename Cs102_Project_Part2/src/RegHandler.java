import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegHandler implements ActionListener {
		private JPanel coursePanel;
		private JPanel infoPanel2;
		 	public RegHandler(JPanel coursePanel,JPanel infoPanel2){
		 		this.coursePanel=coursePanel;
		 		this.infoPanel2=infoPanel2;
		 	}

	@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() instanceof JButton){
				JButton button2 = (JButton) e.getSource();
					if(button2.getText().equals("Register Exam Grades")){
						int x =coursePanel.getComponentCount();
							if(x==2){
								coursePanel.remove(x-1);
							}
						coursePanel.add(infoPanel2);
						coursePanel.revalidate();
						coursePanel.repaint();
							
					
					}
							
							
			}
		
	}

}
