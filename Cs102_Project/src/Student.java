import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
	private List<Course> enrolledCourses;
	private List<GradeItem> grades;
		public Student(String name){
			super(name);
			this.initEmail();
			enrolledCourses = new ArrayList<Course>();
			grades = new ArrayList<GradeItem>();
			
		}
		@Override
		public void initEmail() {
			String studentName = this.getName().toLowerCase();
			String [] fullname = studentName.split(" ");
			String studentMail = fullname[0]+"."+fullname[1]+"@ozu.edu.tr";
			this.setEmail(studentMail);
			
		}
			public void registerToCourse(Course course){
				if(course.getInstructor()==null){
					System.out.println("Course not avaliable");
				}
				else {course.addStudent(this) ;
				enrolledCourses.add(course);
				}
			}
			public void dropCourse(Course course){
				course.removeStudent(this);
				enrolledCourses.remove(course);
			}
			public void addGrade(GradeItem gradeitem){
				grades.add(gradeitem);
			}
			public GradeItem getGradeItem(String courseid,String examid){
				GradeItem foundedGrade = null;
				for(int k=0;k<grades.size();k++){
					if(grades.get(k).getCourseId().equals(courseid) && grades.get(k).getExamId().equals(examid) ) {
						foundedGrade = grades.get(k);
					}
					
				}
				
				return foundedGrade;
			}
			public void listGrades(){
				ArrayList<GradeItem> tempGrades = new ArrayList<GradeItem>();
				ArrayList<GradeItem> tempGrades2 = new ArrayList<GradeItem>();
					for(int a=0;a<grades.size();a++){
						tempGrades.add(grades.get(a));
						tempGrades2.add(grades.get(a));
					}
				for(int i=0; i<tempGrades.size();i++){
					String result = "";
					String exams = "";
					String tempCourseId="";
					for(int j=0;j<tempGrades2.size();j++){
						if(tempGrades.get(i).getCourseId().equals(tempGrades2.get(j).getCourseId())){
								exams+="["+tempGrades2.get(j).getExamId()+": " + tempGrades2.get(j).getGrade()+"]";
								 tempCourseId =	tempGrades.get(i).getCourseId();
							
						}
					}
					
					
					result += tempCourseId+" grades of "+this.getName()+": " +exams;
					for(int b=0;b<tempGrades.size();b++){
						if(tempGrades.get(b).getCourseId().equals(tempCourseId)){
							tempGrades.remove(tempGrades.get(b));
						}
					}
					
					System.out.println(result);
					
				}
			}

}
		
