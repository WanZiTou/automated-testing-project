package infocenter.base;

import infocenter.page.LoginPage;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.sand.qa.database.DBUtil;
import com.sand.qa.util.Logger;
import com.sand.qa.webdriver.DriverBase;

public class TestBase  extends DriverBase{
	
	
	
	
	LoginPage loginPage = null;
	String url="https://www.baidu.com/";
	
	
	/*DBUtil oracle = new DBUtil("O");
	public DBUtil getOracle() {
		return oracle;
	}*/
	
	
	@BeforeClass
	public void beforeBaseClass() {
		//oracle.connection();
		Logger.log("+++++++++++++++++++++++++++++连接数据库");
		//loginPage = PageFactory.initElements(driver, LoginPage.class);
		
	} 
	
	
	@AfterClass(alwaysRun = true)
	public void afterBaseClass() {
		//oracle.close();
		System.out.print("+++++++++++++++++++++++++++++关闭数据库");
	}
	


	@BeforeTest
	public void beforeTestBase() {
		launch();
		
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		
		quit();
	}


	



	/*@BeforeSuite
	public void Conne() {
		mysql.connection();
	}

	@AfterSuite
	public void killConne() {
		
		mysql.close();
	}*/


	/**
	 * quit browser
	 */
	private void quit() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	
	
	//登录共用方法
	public void commenLogin(String userName, String passWord,LoginPage loginPage){
		
		this.loginPage=loginPage;
		driver.get(url);
		delay(2);	
//		
//		input(loginPage.userName, userName);
//		delay(2);
//		
//		input(loginPage.passWord, passWord);
//		delay(2);
//		
//		click(loginPage.loginSubmit);		
		delay(2);
	}
	
	//注销共用方法
	public void loginOut()throws Exception{
		Logger.log("开始注销");
		lightElement(loginPage.loginOut);
        click(loginPage.loginOut);
		delay(2);
		alertConfirm();
		delay(5);
		Assert.assertTrue(isElementPresent(loginPage.userName), "注销成功"); 
	}
	
	//登录验证共用方法
	public void commenReg(String userName,String passWord,String regMessage)throws Exception{
		commenLogin(userName,passWord,loginPage);
		delay(2);
		Alert alert= getAlertText();
		Assert.assertTrue(alert.getText().contains(regMessage));
		delay(2);
		alert.accept();
		delay(2);
	}
	
}
