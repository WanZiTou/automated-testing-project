package infocenter.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipOverPage {
	
	
	
	@FindBy(xpath=".//*[@id='page']/div/a[1]")
	public WebElement first;
	
	@FindBy(xpath=".//*[@id='page']/div/a[2]")
	public WebElement previous; 
	
	@FindBy(xpath=".//*[@id='page']/div/a[3]")
	public WebElement next; 
	
	@FindBy(xpath=".//*[@id='page']/div/a[4]")
	public WebElement last; 
	
	@FindBy(xpath=".//*[@id='current_count']")
	public WebElement currentCount;
	
	

}
