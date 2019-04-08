package service;

import java.util.List;
import domain.Information;

/**
 * Information对应的业务逻辑接口，提供一些与信息相关的业务逻辑操作的公开的方法声明
 */
public interface IInfoService {
	
	//添加一条发布信息到数据库
	public void addInfo(Information information);

	//获取所有信息列表
	public List<Information> getAllInfo();
}
