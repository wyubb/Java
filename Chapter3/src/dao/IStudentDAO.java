package dao;

import java.util.List;
import domain.Student;

/**
 * Student类对应的DAO接口，提供一些与用户相关的数据库CRUD操作的公开的方法声明
 * @author Administrator
 *
 */
public interface IStudentDAO {
		//添加一个学生用户到数据库
		public void addStudent(Student student);
		//根据用户编号获取用户信息，以Student对象的形式返回
		public Student getStudentByID(String id);
		//根据学生学号获取用户信息，以Student对象的形式返回
		public List<Student> getStudentByUserName(String userName);
		//根据班级编号获取该班级所有学生的名单
		public List<Student> getStuedntByClass(String student_class);
		//查看某学生在班级的排名
		
		//根据专业编号获取该专业所有学生名单
		public List<Student> getStudentBySdept(String speciality);
		//查询数据表里所有学生信息，按照绩点排序
		public List<Student> getAllStudent();
		//查询数据表某专业所有学生信息，按照绩点排序
		public List<Student> getSdeptStudent(String speciality);
		//查询数据表里某班级所有学生信息，按照绩点排序
		public List<Student> getClassStudent(String student_class);
		//更新学生用户信息
		public void updateStudent(Student student );
		//删除学生用户
		public void deleteStudent(String student_id);
}
