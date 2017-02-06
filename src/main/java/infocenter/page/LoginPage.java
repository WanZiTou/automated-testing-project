package infocenter.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(id="userName")
	public WebElement userName; //用户名
	
	@FindBy(id="userPwd")
	public WebElement passWord; //密码
	
	@FindBy(id="login")
	public WebElement loginSubmit; //登录按钮
	
	@FindBy(xpath="html/body/div[1]/span[4]")
	public WebElement indexUserName; //登录后的用户名称
	
	@FindBy(xpath="html/body/div[1]/span[4]/span[1]")
	public WebElement currentDate; //登录后的当前日期
	
	@FindBy(xpath="html/body/div[1]/div[2]/img")
	public WebElement loginOut; //注销按钮
	
	
	
	

}
