package infocenter.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IssueLogPage extends FlipOverPage{
	
	@FindBy(id="start_time")
	public WebElement startTime;
	
	@FindBy(id="end_time")
	public WebElement endTime;
	
	@FindBy(id="data_name")
	public WebElement dataName;
	
	@FindBy(id="result")
	public WebElement result;
	
	@FindBy(id="queryBut")
	public WebElement queryBut;
	
	@FindBy(xpath=".//*[@id='menu1']")
	public WebElement  menuId;
	
	@FindBy(xpath=".//*[@id='item2_submenu1']/div")
	public WebElement  ItemId;
	
	@FindBy(xpath=".//*[@id='logTbody']")
	public WebElement table;
	

}
