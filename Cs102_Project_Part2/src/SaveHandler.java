import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SaveHandler implements ActionListener {	
			private JPanel coursePanel;
			private JPanel infoPanel2;
			private Course course ;
			
				public SaveHandler(JPanel infoPanel2,Course course){
					this.coursePanel=coursePanel;
			 		this.infoPanel2=infoPanel2;
			 		this.course=course;
			 	
				}
					ArrayList<String> grades = new ArrayList<String>();
						
				String examId="";
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() instanceof JButton){
						JButton button3= (JButton) e.getSource();
							if(button3.getText().equals("Save")){
									for(int i=0;i<infoPanel2.getComponentCount();i++){
										if(infoPanel2.getComponent(i) instanceof JTextField){
											String grade =((JTextField) infoPanel2.getComponent(i)).getText();
											grades.add(grade);
										}
									}
							}
								 examId = grades.get(0);
								
								grades.remove(0);
									boolean gradescheck=true;
										for(int i=0;i<grades.size();i++){
											int grade =  Integer.parseInt(grades.get(i));
											if(grade<0||grade>100) gradescheck=false;
										}
										if(gradescheck==true){
											for(int a=0;a<course.getStudents().size();a++){
												int grade =  Integer.parseInt(grades.get(0));
												GradeItem studentgrade = new GradeItem(course.getId(),examId,grade);
												course.getStudents().get(a).addGrade(studentgrade);
											}
											JOptionPane.showMessageDialog(null, "Grades are saved");
										}	
										if(gradescheck==false){
											JOptionPane.showMessageDialog(null, "Grades must be between 0 and 100");
										}
											
											
											
										
							
					}
					
				}
					
				
				
	
}
