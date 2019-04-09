package dao;

import java.util.List;

import domain.Classes;

/**
 * Classes 类对应DAO接口，提供一些与用户相关的数据库CRUD操作的公开的方法声明
 * @author Administrator
 *
 */
public interface IClassesDAO {
	//添加一个班级到数据库
	public void addClasses(Classes classes);
	
	//获取所有班级信息
	public List<Classes> getAllClasses();
	//更新班级信息
	public void updateClass(Classes classes);
	//根据班级编号删除班级
	public void deleteClass(String classes_id);
	
	
}
