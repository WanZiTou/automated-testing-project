package infocenter.util;

import infocenter.base.TestBase;
import infocenter.page.LoginPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import com.sand.qa.util.Logger;

public class CommenLogin extends TestBase{
	
	String url="http://127.0.0.1:8080/OilReport/login.html";
	LoginPage loginPage=null;
	
	@BeforeClass
	public void init() {
		
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		
	} 
	public void commenLogin(String userName, String passWord){
		
		driver.get(url);
		delay(2);	
		
		input(loginPage.userName, userName);
		delay(2);
		
		input(loginPage.passWord, passWord);
		delay(2);
		
		click(loginPage.loginSubmit);		
		delay(2);
	}
	
	
	public void loginOut()throws Exception{
		Logger.log("开始注销");
		lightElement(loginPage.loginOut);
        click(loginPage.loginOut);
		delay(2);
		alertConfirm();
		delay(2);
		alertConfirm();
		delay(5);
		Assert.assertTrue(isElementPresent(loginPage.userName), "注销成功"); 
	}
	
	public void commenReg(String userName,String passWord,String regMessage)throws Exception{
		commenLogin(userName,passWord);
		delay(2);
		Alert alert= getAlertText();
		Assert.assertTrue(alert.getText().contains(regMessage));
		delay(2);
		alert.accept();
		delay(2);
	}
}
