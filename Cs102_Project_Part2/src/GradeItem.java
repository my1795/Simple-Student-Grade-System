public class GradeItem {
	
	private String courseId;
	private String examId;
	private int grade;
		public GradeItem(String courseId,String examId,int grade){
			this.courseId=courseId;
			this.examId=examId;
			this.grade=grade;
		}
		public String getCourseId(){
			return courseId;
		}
		public String getExamId(){
			return examId;
		}
		public int getGrade(){
			return grade;
		}
		public void setCourseId(String courseId){
			this.courseId=courseId;
			
		}
		public void setExamId(String examId){
			this.examId=examId;
		}
		public void setGrade(int grade){
			this.grade=grade;
		}
		
	
			public String toString(){
				return "This "+ courseId+"'s "+examId+"'s grade is"+ grade; 
			}
}
