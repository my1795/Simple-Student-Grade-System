import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class InstructorFrame extends JFrame {

	private Instructor instructor;

	public InstructorFrame(Instructor instructor) {
		super(instructor.getName());
		this.instructor = instructor;
		init();
	}

	private void init() {
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		//this.setResizable(false);

		JTabbedPane tabbedPane = new JTabbedPane();
		

		// You won't use this particular code. 
		// You need to modify it
		// Just use it as an example to create course tabbedpanes.
		String panelName="";
		for(int k=0; k<instructor.getInstructorCourses().size();k++){
			panelName= instructor.getInstructorCourses().get(k).getId();
			
			JPanel coursePanel = new JPanel();
			coursePanel.setLayout(new GridLayout(2,1));
			JPanel infoPanel = new JPanel();
			infoPanel.setLayout(new GridLayout(0,3));
			JPanel idPanel = new JPanel();
			idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.Y_AXIS));
			JLabel idHead = new JLabel("ID");
			idHead.setFont(new Font("Courier New",Font.BOLD,15));
			idHead.setForeground(Color.BLUE);
			idPanel.add(idHead);
			JPanel namePanel = new JPanel();
			namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
			JLabel nameHead= new JLabel("NAME");
			nameHead.setFont(new Font("Courier New",Font.BOLD,15));
			nameHead.setForeground(Color.BLUE);
			namePanel.add(nameHead);
			JPanel emailPanel = new JPanel();
			emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.Y_AXIS));
			JLabel emailHead = new JLabel("EMAIL");
			emailHead.setFont(new Font("Courier New",Font.BOLD,15));
			emailHead.setForeground(Color.BLUE);
			emailPanel.add(emailHead);
				
				for(int a=0;a<instructor.getInstructorCourses().get(k).getStudents().size();a++){
					idPanel.add(new JLabel(instructor.getInstructorCourses().get(k).getStudents().get(a).getId()));
					namePanel.add(new JLabel(instructor.getInstructorCourses().get(k).getStudents().get(a).getName()));
					emailPanel.add(new JLabel(instructor.getInstructorCourses().get(k).getStudents().get(a).getEmail()));
				}
							
				 			JPanel infoPanel2= new JPanel();
				 			infoPanel2.setLayout(new GridLayout(0,3));
				 			infoPanel2.add(new JLabel("Enter Exam Id:"));
				 			infoPanel2.add(new JLabel());
				 			JTextField examIdEntry = new JTextField();
				 			infoPanel2.add(examIdEntry);
				 			infoPanel2.add(new JLabel());
				 			infoPanel2.add(new JLabel());	
				 			infoPanel2.add(new JLabel());
				 			infoPanel2.add(new JLabel("ID:"));
				 			infoPanel2.add(new JLabel("NAME:"));
				 			infoPanel2.add(new JLabel("GRADE:"));
				 				
				 			for(int b=0;b<instructor.getInstructorCourses().get(k).getStudents().size();b++){
								infoPanel2.add(new JLabel(instructor.getInstructorCourses().get(k).getStudents().get(b).getId()));
								infoPanel2.add(new JLabel(instructor.getInstructorCourses().get(k).getStudents().get(b).getName()));
									JTextField textfield = new JTextField();
									infoPanel2.add(textfield);
								
							}
				 			infoPanel2.add(new JLabel());
				 			JButton saveButton = new JButton("Save");
				 			infoPanel2.add(saveButton);
				 			infoPanel2.add(new JLabel());
				 	
				 			
				 			
				 			
					
				infoPanel.add(idPanel);
				infoPanel.add(namePanel);
				infoPanel.add(emailPanel);
				JButton listStudents = new JButton("List Students");
				JButton REGrades = new JButton("Register Exam Grades");
				JButton listGrades = new JButton("List Grades");
				JPanel controlPanel = new JPanel();
				
				controlPanel.add(listStudents);
				controlPanel.add(REGrades);
				controlPanel.add(listGrades);
				coursePanel.add(controlPanel);
				listStudents.addActionListener(new StudentListHandler(coursePanel,infoPanel));
				REGrades.addActionListener(new RegHandler(coursePanel,infoPanel2));
				saveButton.addActionListener(new SaveHandler(infoPanel2,instructor.getInstructorCourses().get(k)));
					
						
						
				
				
			tabbedPane.addTab(panelName,coursePanel);
			
			
				
				
				
			
			
		}
				
		
		////////////////////////////////////
		
		this.add(tabbedPane);
		
		this.setVisible(true);

	}

}
