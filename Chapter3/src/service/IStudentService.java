package service;

import java.util.List;

import domain.Student;
import domain.User;

public interface IStudentService {
	//添加学生信息到数据库
	public void addStudent(Student student) ;
	//根据学生编号获取学生信息
	public Student getStudentByID(String student_id);
	//验证学生用户登录名和密码是否合法
	public Student validateStudent(String student_id,String student_password);
	//验证学生用户名是否已经存在
	public boolean isStudentExist(String student_id);
	//根据学生学号获取绩点
	public Student getGpa(String student_id);
	//获取所有学生列表
	public List<Student> getAllStudent();
	//获取某专业学生列表
	public List<Student> getSdeptStudent(String speciality);
	//获取某班级学生列表
	public List<Student> getClassStudent(String classes_id);
	//更新个人资料
	public void updateStudent(Student student);	
	//删除管理员用户
	public void deleteStudent(String student_id);
}
