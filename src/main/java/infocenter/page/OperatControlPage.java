package infocenter.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OperatControlPage extends FlipOverPage{

	@FindBy(id="start_time")
	public WebElement startTime;
	
	@FindBy(id="end_time")
	public WebElement endTime;
		
	@FindBy(id="result")
	public WebElement result;
	
	@FindBy(id="queryBut")
	public WebElement queryBut;
	
	@FindBy(xpath=".//*[@id='menu1']")
	public WebElement  menuId;
	
	@FindBy(xpath=".//*[@id='item1_submenu1']/div")
	public WebElement  ItemId;
	
	@FindBy(xpath=".//*[@id='logTbody']")
	public WebElement table;
	
}
