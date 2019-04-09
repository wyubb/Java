package dao;

import java.util.List;

import domain.User;

/**
 * User类对应的DAO接口，提供一些与用户相关的数据库CRUD操作的公开的方法声明
 * @author Administrator
 *
 */
public interface IUserDAO {
	//添加一个用户到数据库
	public void addUser(User user);
	//更新管理员用户信息
	public void updateUser(User user);
	//删除用户
	public void deleteUser(String username);
	//根据用户编号获取用户信息，以User对象的形式返回
	public User getUserByID(String id);
	//根据用户名获取用户信息，以User对象的形式返回
	public List<User> getUserByUserName(String userName);
	
	
	
	
}
