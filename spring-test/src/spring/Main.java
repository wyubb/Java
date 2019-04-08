package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//1.创建HelloWorld的一个对象
		//HelloWorld helloworld = new HelloWorld();
		//2.为user属性赋值
		//helloworld.setUser("Amy");
		//3.调用hello()
		//helloworld.hello();
		
		//1.创建Spring 的IOC容器
		//ApplicationContext 代表IOC容器
		//ClassPathXmlApplicationContext : 是AppliationContext 接口的实现类，该实现类从类路径下来加载配置文件
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2.从IOC容器中获取bean实例
		//利用id定位到IOC容器中的bean
		HelloWorld helloworld = (HelloWorld) ctx.getBean("helloworld");
		System.out.println(helloworld);
		//3.调用hello()
		helloworld.hello();
	}

}
