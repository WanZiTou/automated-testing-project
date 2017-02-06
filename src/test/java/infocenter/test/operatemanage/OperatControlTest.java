package infocenter.test.operatemanage;

import infocenter.base.TestBase;
import infocenter.page.LoginPage;
import infocenter.page.OperatControlPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.MathRandom;
import util.StringTools;
import util.VeDate;

import com.sand.qa.util.Logger;

public class OperatControlTest extends TestBase{
	
	OperatControlPage opcPage=null;
	LoginPage loginPage = null;
	
	@BeforeClass
	public void initPage(){
		opcPage = PageFactory.initElements(driver, OperatControlPage.class);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
	}
	
	//输入正确的用户名，正确的密码，点击登录按钮
	@Test(dataProvider = "xml")
	public void login(String userName,String passWord){
		commenLogin(userName, passWord,loginPage);
		delay(2);
	}
	
	@Test(dataProvider="xml")
	public void queryDataByConditions(String startTime,String endTime,String result ){
		
		isElementPresent(opcPage.ItemId);
		click(opcPage.ItemId);
		delay(2);
		switchFrameByName("right");
		delay(2);
		jsExecutor(opcPage.startTime,"document.getElementById('start_time').readOnly=false;");
		driver.findElement(By.id("start_time")).sendKeys(startTime);
		delay(2);
		jsExecutor(opcPage.endTime,"document.getElementById('end_time').readOnly=false;");
		driver.findElement(By.id("end_time")).sendKeys(endTime);
		delay(2);
	    
	    selectWithoutCheck(opcPage.result, result);
	    delay(2);
	    
	    click(opcPage.queryBut);
	    delay(2);
        
	   //检查点1：无匹配数据时的查询结果
	    WebElement table=opcPage.table;
	  
	  	boolean flag=  getCellText(table,0,0).contains("没有查询到数据");
	   	if (flag) {
			   Logger.log("没有查询到数据");
			   return;
		}
		
	   String current= opcPage.currentCount.getAttribute("value");
	   Logger.log("currentCount"+current); 
	   
	   //获得总页数
	   int pages=StringTools.getMatchPage(current,"/ (.*)页");
	   int rownum=0;
	   if (pages>1) {
		   rownum= MathRandom.getRandom(10);
	   }
	   //检查点2：检查第一页 随机一条记录的 查询结果和条件是否一致
	   Assert.assertTrue(VeDate.isBetween(getCellText(table,rownum,1),startTime,endTime));
	   Assert.assertTrue(getCellText(table,rownum,3).contains(result)); 
	   
	   //检查点3：末尾页第一条数据   查询结果是否和结果匹配
	   if (pages>1) {
		   click(opcPage.last);
		   Assert.assertTrue(VeDate.isBetween(getCellText(table,0,1),startTime,endTime));
		   Assert.assertTrue(getCellText(table,0,3).contains(result));
	   }
	   
	   
	  
     }

}
