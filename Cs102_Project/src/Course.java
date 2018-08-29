import java.util.ArrayList;
import java.util.List;

public class Course {
	private String id;
	private String name;
	private Instructor instructor;
	private List<Student> students;
		
		public Course(String id,String name){
			this.id=id;
			this.name=name;
			students = new ArrayList<Student>();
		}
		public void addStudent(Student student){
			students.add(student);
		}
		public void removeStudent(Student student){
			students.remove(student);
		}
		public String getId(){
			return id;
		}
		public String getName(){
			return name;
		}
		public Instructor getInstructor(){
			return instructor;
		}
		public List<Student> getStudents(){
			return students;
		}
		public void setInstructor(Instructor instructor){
			this.instructor=instructor;
		}
		public void listStudents(){
			System.out.println("Students registered in "+this.name+" are : ");
			for(int k=0;k<students.size();k++){
				System.out.println(students.get(k).getName());
			}
		}
		public String toString(){
			return "This " + name+"("+id+")"+" course 's instructor is"+ instructor;
		}
}
