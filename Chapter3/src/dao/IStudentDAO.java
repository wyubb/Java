package dao;

import java.util.List;
import domain.Student;

/**
 * Student���Ӧ��DAO�ӿڣ��ṩһЩ���û���ص����ݿ�CRUD�����Ĺ����ķ�������
 * @author Administrator
 *
 */
public interface IStudentDAO {
		//���һ��ѧ���û������ݿ�
		public void addStudent(Student student);
		//�����û���Ż�ȡ�û���Ϣ����Student�������ʽ����
		public Student getStudentByID(String id);
		//����ѧ��ѧ�Ż�ȡ�û���Ϣ����Student�������ʽ����
		public List<Student> getStudentByUserName(String userName);
		//���ݰ༶��Ż�ȡ�ð༶����ѧ��������
		public List<Student> getStuedntByClass(String student_class);
		//�鿴ĳѧ���ڰ༶������
		
		//����רҵ��Ż�ȡ��רҵ����ѧ������
		public List<Student> getStudentBySdept(String speciality);
		//��ѯ���ݱ�������ѧ����Ϣ�����ռ�������
		public List<Student> getAllStudent();
		//��ѯ���ݱ�ĳרҵ����ѧ����Ϣ�����ռ�������
		public List<Student> getSdeptStudent(String speciality);
		//��ѯ���ݱ���ĳ�༶����ѧ����Ϣ�����ռ�������
		public List<Student> getClassStudent(String student_class);
		//����ѧ���û���Ϣ
		public void updateStudent(Student student );
		//ɾ��ѧ���û�
		public void deleteStudent(String student_id);
}
