import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Instructor extends Person {
		private List<Course> courses;
		
			public Instructor(String name) {
				super(name);
				courses = new ArrayList<Course>();
				this.initEmail();
	}	
				public void addCourse(Course course){
					courses.add(course);
			}

	
					public void initEmail() {
						String instructorName = this.getName();
						String [] fullname = instructorName.split(" ");
						String instructorMail = fullname[0].toLowerCase()+"."+fullname[1].toLowerCase()+"@ozyegin.edu.tr";
						this.setEmail(instructorMail);
		
					}
						public void registerExamGrades(String courseId,String examId){
								boolean isInstructorExist=false;
								Random random = new Random();
								for(int k=0;k<courses.size();k++){
									if(courses.get(k).getId().equals(courseId)) isInstructorExist=true;
								}
								if(isInstructorExist==false){
									System.out.println("Instructor "+this.getName()+" cannot grade the course " +courseId+".");
								}
								if(isInstructorExist==true){
									for(int j=0;j<courses.size();j++){
										for(int s=0;s<courses.get(j).getStudents().size();s++){
											GradeItem gradeStudent = new GradeItem(courseId,examId,random.nextInt(100));
											courses.get(j).getStudents().get(s).addGrade(gradeStudent);
											
										}
									}
								}
						}
							public void listGradesForExam(String courseId,String examId){
								
									for(int i=0;i<courses.size();i++){
										if(courses.get(i).getId().equals(courseId)){
											System.out.println(courseId+" "+examId+" grades are:");
											for(int j=0;j<courses.get(i).getStudents().size();j++){
												if(courses.get(i).getStudents().get(j).getGradeItem(courseId, examId).getExamId().equals(examId)){
													System.out.println(courses.get(i).getStudents().get(j).getName()+": "+"["+examId+": "+courses.get(i).getStudents().get(j).getGradeItem(courseId, examId).getGrade()+"]");
												}
											}
										}
									}
							}
									public void printAverageGradeForExam(String courseId,String examId){
										double grades=0;
										int gradeCount=0;
										for(int i=0;i<courses.size();i++){
											if(courses.get(i).getId().equals(courseId)){
												for(int j=0;j<courses.get(i).getStudents().size();j++){
													if(courses.get(i).getStudents().get(j).getGradeItem(courseId, examId).getExamId().equals(examId)){
														grades+=courses.get(i).getStudents().get(j).getGradeItem(courseId, examId).getGrade();
														gradeCount++;
													}
												}
											}
										}
										double result= grades/gradeCount;
										System.out.println(courseId+" "+examId+" average is: "+result);
										
									}

}
