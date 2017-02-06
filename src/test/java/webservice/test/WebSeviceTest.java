package webservice.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.meihuichina.webservice.PublishInformationCenterData;
import com.meihuichina.webservice.PublishInformationCenterDataService;
import com.sand.qa.util.Base;
import com.sand.qa.util.Logger;

public class WebSeviceTest extends Base{
	
	
	PublishInformationCenterDataService service = new PublishInformationCenterDataService();
	PublishInformationCenterData soap = service
			.getPublishInformationCenterData();
	
	@BeforeTest
	public void before(){
		Logger.log("进入测试-----");
	}

	/*
	 * 业务功能测试：正常场景
	 * 测试getTrafficDataByDataName接口
	 */
	@Test(dataProvider = "xml")
	public void testTrafficData(String userName,String passWord,String dataName){
		long ts = new Date().getTime();
		String sig = PasswordMD5.encodeByMD5(userName + passWord + ts);
		String data=soap.getTrafficDataByDataName(userName, ts, sig, dataName);
		outPutFile( data,dataName);
		
	}
	
	/*
	 * 业务功能测试：正常场景
	 * 测试getDataCountByDataName接口
	 */
	@Test(dataProvider = "xml")
	public void testDataCount(String userName,String passWord,String dataName){
		long ts = new Date().getTime();
		String sig = PasswordMD5.encodeByMD5(userName + passWord + ts);
		String data=soap.getTrafficDataByDataName(userName, ts, sig, dataName);
		outPutFile( data,dataName);
		String count=soap.getDataCountByDataName(userName, ts, sig, dataName);
		int actualCount=readxml(dataName);
		//判断getDataCountByDataName接口获取的数据量是否与实际相等。
		Logger.log("actualCount:"+actualCount);
		Logger.log("返回Count："+count);
	}
	
	/*
	 * 业务功能测试：正常场景
	 * 测试 getTrafficDataByDataNameAndPage 接口
	 */
	@Test(dataProvider = "xml")
	public void  testSearchByPage(String userName,String passWord,String dataName,int pageNum){
		long ts = new Date().getTime();
		String sig = PasswordMD5.encodeByMD5(userName + passWord + ts);
		String data=soap.getTrafficDataByDataNameAndPage(userName, ts, sig, dataName, pageNum);
		Logger.log("AndPagedata:"+data);
		outPutFile( data,dataName+pageNum);
		int actualCount=readxml(dataName+pageNum);
		//固定设置每页返回1000条
		int exceptCount=1000;
		Assert.assertEquals(actualCount, exceptCount);
	}
	
	/*
	 * 边界分析测试：输入参数边界分析
	 * 测试(参数：账户名、密码)
	 */
	@Test(dataProvider = "xml")
	public void checkInParameter(String userName,String passWord,String dataName){
		long ts = new Date().getTime();
		String sig = PasswordMD5.encodeByMD5(userName + passWord + ts);
		
		String data=soap.getTrafficDataByDataName(userName, ts, sig, dataName);
		//Logger.log("data:"+data);
		Logger.log("dataName:"+dataName+"-userName:"+userName+"-password:"+passWord+"-getTrafficData");
		
		String dataByPage=soap.getTrafficDataByDataNameAndPage(userName, ts, sig, dataName, 1);
		//Logger.log("dataByPage:"+dataByPage);
		Logger.log("dataName:"+dataName+"-userName:"+userName+"-password:"+passWord+"-AndPage");
		
		String dataCount=soap.getDataCountByDataName(userName, ts, sig, dataName);
		Logger.log("dataCount:"+dataCount);
		Logger.log("dataName:"+dataName+"-userName:"+userName+"-password:"+passWord+"-getDataCount");
		
	}
	
	
	
	
	
	@AfterTest
	public void test(){
		Logger.log("退出测试-----");
	}
	
	public int readxml(String dataName){
		int count=0;
		 try {   
			    File f = new File( "webservice-output/"+dataName+".xml");   
			    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
			    DocumentBuilder dombuilder = factory.newDocumentBuilder();
				InputStream is = new FileInputStream(f);
				Document doc = dombuilder.parse(is);
			    NodeList record = doc.getElementsByTagName("record"); 
			    NodeList field = doc.getElementsByTagName("field"); 
			    Logger.log("record.size:"+record.getLength());
			    Logger.log("field.size:"+field.getLength());
			    count=field.getLength();
		   } catch (Exception e) {   
			    e.printStackTrace();   
	   	   }  
		 return count;
			  
	}
	
	public  void outPutFile(String data,String dataName) {
		
		File dir = new File("webservice-output/");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String path = "webservice-output/"+dataName+".xml";
		FileOutputStream fos;
		 try {
				fos = new FileOutputStream(path);
				OutputStreamWriter outs = new OutputStreamWriter(fos,"UTF-8");	
				BufferedWriter bw = new BufferedWriter(outs);
				bw.write(data);
				bw.newLine();
				
				bw.flush();
				bw.close();
				outs.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	public static String getString (){
		return new StringBuffer ("abcdefc").reverse().toString();
	}
	public static void main(String[] args) {
		String a=getString();
		System.out.println(a);
	}

}
		
		

