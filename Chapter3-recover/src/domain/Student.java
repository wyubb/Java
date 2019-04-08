package domain;

public class Student {
		private String student_id;
		private String student_name;
		private String student_sex;
		private String student_tel;
		private String student_password;
		private int grade;
		private String student_class;
		
		private String gpa;				
		public String getGpa() {
			return gpa;
		}
		public void setGpa(String gpa) {
			this.gpa = gpa;
		}
		
		public String getStudent_class() {
			return student_class;
		}
		public void setStudent_class(String student_class) {
			this.student_class = student_class;
		}
		public String getStudent_id() {
			return student_id;
		}
		public void setStudent_id(String student_id) {
			this.student_id = student_id;
		}
		public String getStudent_name() {
			return student_name;
		}
		public void setStudent_name(String student_name) {
			this.student_name = student_name;
		}
		public String getStudent_sex() {
			return student_sex;
		}
		public void setStudent_sex(String student_sex) {
			this.student_sex = student_sex;
		}
		public String getStudent_tel() {
			return student_tel;
		}
		public void setStudent_tel(String student_tel) {
			this.student_tel = student_tel;
		}
		public String getStudent_password() {
			return student_password;
		}
		public void setStudent_password(String student_password) {
			this.student_password = student_password;
		}
		public int getGrade() {
			return grade;
		}
		public void setGrade(int grade) {
			this.grade = grade;
		}
		
}
