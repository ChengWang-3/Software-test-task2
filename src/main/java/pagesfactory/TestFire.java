package pagesfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestFire {

	WebDriver driver;
	@FindBy(id="uid")
	WebElement elementOfUserName;//用户id
	
	@FindBy(id="passw")
	WebElement elementOfPassword;//用户密码
	
	@FindBy(css="#login > table > tbody > tr:nth-child(3) > td:nth-child(2) > input[type=submit]")
	WebElement login;//登录按钮
	
	@FindBy(xpath="//*[@id=\"_ctl0__ctl0_Content_Main_promo\"]/table/tbody/tr[1]/td/h2")
	WebElement targetText;//目标文本
	
	public TestFire(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//设置uid
	public void setUid(String uid){
		elementOfUserName.sendKeys(uid);
	}
	
	//设置password
	public void setPassword(String password){
		elementOfPassword.sendKeys(password);
	}
	
	//点击登录按钮
	public void clickLogin(){
		login.click();
	}
	
	//获取目标文本
	public String getTargetText(){
	 return	targetText.getText();
	}
	
	public void loginToTestfire(String uid,String password){
		this.setUid(uid);
		this.setPassword(password);
		this.clickLogin();
	}
	
}
