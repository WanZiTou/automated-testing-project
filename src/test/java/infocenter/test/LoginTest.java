package infocenter.test;

import infocenter.base.TestBase;
import infocenter.page.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {
	
	
	LoginPage loginPage = null;
	
	@BeforeClass
	public void initPage(){
		loginPage = PageFactory.initElements(driver, LoginPage.class);
	}

	
	//输入正确的用户名，正确的密码，点击登录按钮
	@Test(dataProvider = "xml",groups={"login"})
	public void login(String userName, String passWord) throws Exception {
		commenLogin(userName,passWord,loginPage);
		
		boolean  flag=isElementPresent(driver.findElement(By.xpath("html/body/div[1]/span[contains(text(),'"+userName+"')]")));
		Assert.assertTrue(flag, "检查点：是否登录成功"); 
		delay(2);
		
	}
	
	@Test(groups={"login_out"})
	public void login_out() throws Exception{
		loginOut();
	}

	/*@Test(dataProvider="xml")
	public void login_reg(String userName,String passWord,String regMessage)throws Exception{
		
	commenReg(userName,passWord,regMessage);
		
	}*/
	
	
	/**验证用户名和密码是否为空
	@Test(dataProvider="xml")
	public void login_isReg(String userName, String passWord,String compareStr,String regMessage)throws Exception{
		
		if ((userName.isEmpty()||userName==null)&&((passWord.isEmpty()||passWord==null))) {
			Logger.log("当用户名和密码同时为空，登录系统");
			commenReg(userName,passWord,compareStr,regMessage);
		}else if(!userName.isEmpty()&&((passWord.equals("")||passWord==null))){
			Logger.log("当用户名为空，密码正确，登录系统");
			commenReg(userName,passWord,compareStr,regMessage);
		}else if((userName.equals("")||userName==null)&&!passWord.isEmpty()){
			Logger.log("当用户名正确，密码为空，登录系统");
			commenReg(userName,passWord,compareStr,regMessage);
		}
	}**/
	
}
