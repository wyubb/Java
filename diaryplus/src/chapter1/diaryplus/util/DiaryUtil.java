package chapter1.diaryplus.util;

import chapter1.diary.bean.Diary;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class DiaryUtil {

	/**
	　*把java的可序列化的对象(实现Serializable接口)序列化保存到XML文件里面,如果想一次保存多个可序列化对象请用集合进行封装
	　*保存时将会用现在的对象原来的XML文件内容
	　*@paramobj要序列化的可序列化的对象
	　*@paramfileName带完全的保存路径的文件名
	　*@throwsFileNotFoundException指定位置的文件不存在
	　*@throwsIOException输出时发生异常
	　*@throwsException其他运行时异常
	　*/
	public static void diaryToXml(ArrayList<Diary> diaries)
    throws FileNotFoundException, IOException
 {
		//创建输出文件
		File fo=new File("e:\\diaries.xml");
		//文件不存在,就创建该文件
		if(!fo.exists())
		{
			//先创建文件的目录
	        fo.createNewFile();
		
		}
		//创建文件输出流
		FileOutputStream fos=new FileOutputStream(fo);
	//创建XML文件对象输出类实例
	XMLEncoder encoder=new XMLEncoder(fos);
      //对象序列化输出到XML文件
	encoder.writeObject(diaries);
	encoder.flush();
	//关闭序列化工具
        encoder.close();
	//关闭输出流
	fos.close();
	}
	
	/**
	　*读取由objSource指定的XML文件中的序列化保存的对象,返回的结果经过了List封装
	　*@paramobjSource带全部文件路径的文件全名
	　*@return由XML文件里面保存的对象构成的List列表(可能是一个或者多个的序列化保存的对象)
	　*@throwsFileNotFoundException指定的对象读取资源不存在
	　*@throwsIOException读取发生错误
	　*@throwsException其他运行时异常发生
	　*/
	public static ArrayList<Diary> xmlToDiary()
    throws FileNotFoundException, IOException
{
		ArrayList objList=new ArrayList();
		File fin=new File("e:\\diaries.xml");
		FileInputStream fis=new FileInputStream(fin);
       XMLDecoder decoder=new XMLDecoder(fis);
       Object obj=null;
       try
       {
    	   while((obj=decoder.readObject())!=null)
    	   {
    		   objList.add(obj);
    		   }
    	   }
       catch(Exception e)
       {
      }
       fis.close();
       decoder.close();
       System.out.println(objList.size());
       return objList;
	}
	
	}
