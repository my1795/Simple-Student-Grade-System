import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StudentListHandler implements ActionListener{
		
		private JPanel coursePanel;
		private JPanel infoPanel;
		
		public StudentListHandler(JPanel coursePanel,JPanel infoPanel){
			this.coursePanel=coursePanel;
			this.infoPanel=infoPanel;
		
			
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton){
			JButton button1 = (JButton) e.getSource();
				if(button1.getText().equals("List Students")){
					int x =coursePanel.getComponentCount();
					if(x==2){
						coursePanel.remove(x-1);
					}
					coursePanel.add(infoPanel);
					coursePanel.revalidate();
					coursePanel.repaint();
				}
		}
		
	}

}
