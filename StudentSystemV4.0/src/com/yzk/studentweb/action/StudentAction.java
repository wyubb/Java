package com.yzk.studentweb.action;

import java.io.File;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.yzk.studentweb.BaseAction;
import com.yzk.studentweb.model.Student;
import com.yzk.studentweb.server.StudentServet;
import com.yzk.studentweb.serverimp.StudentServerImp;
import com.yzk.studentweb.util.FileUtil;

@SuppressWarnings("serial")
public class StudentAction extends BaseAction {
	private StudentServet serverImp = new StudentServerImp();
	private Logger logger = Logger.getLogger(StudentAction.class);
	private Student student = new Student();
	private String name;
	private ArrayList<Student> lists = new ArrayList<Student>();
	private FileUtil fileUtil = new FileUtil();
	// file上传
	private File file; // 上传文件内容保存到此临时文件中
	private String fileFileContenttype;
	private String fileFileName;

	@Override
	public String execute() throws Exception {
		logger.info("execute");
		return SUCCESS;
	}

	@SuppressWarnings("static-access")
	public String addStudent() {
		if (!serverImp.studentchek(student.getName())) {
			String root = ServletActionContext.getServletContext().getRealPath(
					"/upload");
			File create = new File(root);
			fileUtil.createFile(create);// 文件夹不存在则创建
			serverImp.uploadFile(fileFileName, file, root);
			student.setUrl("/upload/" + fileFileName);
			serverImp.addStudent(student);
			lists = serverImp.selectAllStudent();
			request.setAttribute("lists", lists);
			return SUCCESS;
		}
		request.setAttribute("error", "学生已经存在");
		return INPUT;
	}

	public String deleteStudent() {
		String root = ServletActionContext.getServletContext().getRealPath("");
		serverImp.deleteStudent(request.getParameter("name"),root);
		lists = serverImp.selectAllStudent();
		request.setAttribute("lists", lists);
		return SUCCESS;
	}

	public String upStudent() {
		if (fileFileName == null
				|| serverImp.selectStudentImg(student.getName()).equals(
						fileFileName)) {
			fileFileName = serverImp.selectStudentImg(student.getName());
			student.setUrl(fileFileName);
			serverImp.updateStudent(student, request.getParameter("name"));
			lists = serverImp.selectAllStudent();
			request.setAttribute("lists", lists);
			return SUCCESS;
		}
		String root = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		serverImp.uploadFile(fileFileName, file, root);
		student.setUrl("/upload/" + fileFileName);
		root = ServletActionContext.getServletContext().getRealPath("");
		serverImp.deletefile(root, student.getName());
		serverImp.updateStudent(student, request.getParameter("name"));
		lists = serverImp.selectAllStudent();
		request.setAttribute("lists", lists);
		return SUCCESS;
	}

	public String selectStudent() {
		Student student = serverImp.selectStudentByName(request
				.getParameter("name"));
		request.setAttribute("student", student);
		request.setAttribute("s", student);
		return "selectStudent";
	}

	public String showallStudent() {
		lists = serverImp.selectAllStudent();
		request.setAttribute("lists", lists);
		return SUCCESS;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileContenttype() {
		return fileFileContenttype;
	}

	public void setFileFileContenttype(String fileFileContenttype) {
		this.fileFileContenttype = fileFileContenttype;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
}
