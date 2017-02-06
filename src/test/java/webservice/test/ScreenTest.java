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

public class ScreenTest extends Base{


	PublishInformationCenterDataService service = new PublishInformationCenterDataService();
	PublishInformationCenterData soap = service
			.getPublishInformationCenterData();
	
	@BeforeTest
	public void before(){
		Logger.log("进入测试-----");
	}

	/*
	 * 业务功能测试：筛选条件过滤发布数据
	 * 测试getTrafficDataByDataName接口
	 */
	@Test(dataProvider = "xml")
	public void testScreenParameter(String userName,String passWord,String dataName,int count){
		long ts = new Date().getTime();
		String sig = PasswordMD5.encodeByMD5(userName + passWord + ts);
		String dataByPage=soap.getTrafficDataByDataNameAndPage(userName, ts, sig, dataName,1);
		outPutFile(dataByPage,dataName);
		String countData=soap.getDataCountByDataName(userName, ts, sig, dataName);
		Logger.log("countData:"+countData);
		int actualCount=readxml(dataName);
		Logger.log("actualCount:"+actualCount);
		Assert.assertEquals(count, actualCount, "前台筛选查询结果条数与实际读取条数对比");
		
		String urlData= soap.getImgUrlByAccount(userName, ts, sig);
		outPutFile(urlData,userName+"url");
		
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

}
		

