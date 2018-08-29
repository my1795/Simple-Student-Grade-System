import java.util.ArrayList;
import java.util.List;

		public class Department {
			private String name;
			private List<Course> courses;
			private List<Instructor> instructors;
			private List<Student> students;
			
			public Department(String name){
				this.name=name;
				courses= new ArrayList<Course>();
				instructors = new ArrayList<Instructor>();
				students = new ArrayList<Student>();
			}
			public void addInstructor(String instructorName ){
				instructors.add(new Instructor(instructorName));
			}
			public void addStudent(String studentName){
				students.add(new Student(studentName));
			}
						public void assignInstructorToCourse(String instructorName,String courseId){
									boolean isInstructorExist = false;
									boolean isCourseExist = false;
									Instructor addingIns=null;
									for(int k=0;k<this.instructors.size();k++){
						
										if(this.instructors.get(k).getName().equals(instructorName)){
											isInstructorExist=true;
											addingIns=instructors.get(k);
										}
						
									}
									for(int j=0;j<courses.size();j++){
										if(this.courses.get(j).getId().equals(courseId)){
											isCourseExist=true;
										}
									}
									if(isInstructorExist==true&&isCourseExist==true){
										for(int x=0; x<courses.size();x++){
											if(courses.get(x).getId().equals(courseId)){
												courses.get(x).setInstructor(addingIns);
												addingIns.addCourse(courses.get(x));
											}
										}
									}
									if(isInstructorExist==false){
										System.out.println("Instructor not found: "+instructorName);
									}
									if(isCourseExist==false){
										System.out.println("Course not found: "+courseId);
									}
						}
			public void createCourse(String courseId,String courseName){
				courses.add(new Course(courseId,courseName));
			}
			public List<Instructor> getInstructors(){
				return instructors;
			}
			public Course getCourse(String courseNameorId){
				Course result=null;
				for(int k=0;k<courses.size();k++){
					if(courses.get(k).getName().equals(courseNameorId)||courses.get(k).getId().equals(courseNameorId)) {
						result = courses.get(k);
					}
				}
				return result;
			}
			public List<Student> getStudents(){
				return students;
			}
			public Instructor getInstructorByName(String instructorName){
				Instructor result = null;
				for(int k=0;k<instructors.size();k++){
					if(instructors.get(k).getName().equals(instructorName)){
						result = instructors.get(k);
					}
				}
				return result;
			}
				public void listInstructors(){
				System.out.println("Instuctors registered in this department are: ");
				for(int k=0;k<instructors.size();k++){
					System.out.println(instructors.get(k).getId()+", "+instructors.get(k).getName()+", "+instructors.get(k).getEmail());
				}
			}
					public void listCourses(){
				System.out.println("Courses given by this department are: ");
				for(int k=0; k<courses.size();k++){
					if(courses.get(k).getInstructor()==null){
						System.out.println(courses.get(k).getId()+" "+courses.get(k).getName());
					}
					else{
						System.out.println(courses.get(k).getId()+" "+courses.get(k).getName()+" by "+courses.get(k).getInstructor().getName());
					}
				}
			}
						public void listStudents(){
							System.out.println("Students registered in this department are: ");
							for(int k=0;k<students.size();k++){
								System.out.println(students.get(k).getId()+", "+students.get(k).getName()+", "+students.get(k).getEmail());
							}
						}
	

	}
