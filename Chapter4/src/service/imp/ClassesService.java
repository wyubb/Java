package service.imp;

import java.util.List;

import dao.IClassesDAO;
import dao.imp.ClassesDAO;
import domain.Classes;
import service.IClassesService;

public class ClassesService implements IClassesService{
	//定义IClassesService类型的属性，以实现IClassesService和IClassesDAO实现类之间的协作
	private IClassesDAO classesDAO = new ClassesDAO();
	
	public ClassesService() {
		// TODO Auto-generated constructor stub
	}
	
	//添加一条班级信息到数据库
	public void addClasses(Classes classes) {
		//如果班级为空，则返回，无需添加
		if(classes.getClasses_id() == null) 
			return ;
		
			classesDAO.addClasses(classes);
	}
	//获取所有信息列表
	public List<Classes> getAllClasses(){
		return classesDAO.getAllClasses();
	}
}
