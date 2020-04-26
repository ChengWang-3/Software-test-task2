package pages;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFireOld {
	private final String TARGET_TEXT = "Congratulations!";//目标验证字符串
	
	private WebDriver driver;
	private String url;//测试网址
	
	private WebElement elementOfUserName;//username
	private WebElement elementOfPassword;//password
	private WebElement elementOfLoginButt;//login按钮
	private WebElement elementOfTargetString;//目标字符串
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver_win32/chromedriver.exe");//chromedriver的版本要与浏览器版本相契合
		driver = new ChromeDriver();
		url = "http://www.testfire.net/login.jsp";
		driver.get(url);
		elementOfUserName = driver.findElement(By.id("uid"));//username
		elementOfPassword = driver.findElement(By.id("passw"));//password
		elementOfLoginButt = driver.findElement(By.cssSelector("#login > table > tbody > tr:nth-child(3) > td:nth-child(2) > input[type=submit]"));//login按钮
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
/**
 * 	1.	打开登录页面 http://www.testfire.net/login.jsp
		2.  使用用户名admin，密码admin登录；
		3.	验证登录后的main页面上有字符串“Congratulations!”
 */
	@Test
	public void testfire_login() {
		System.out.println("测试开始");
		elementOfUserName.sendKeys("admin");
		elementOfPassword.sendKeys("admin");
		elementOfLoginButt.click();
		
		elementOfTargetString = driver.findElement(By.xpath("//*[@id=\"_ctl0__ctl0_Content_Main_promo\"]/table/tbody/tr[1]/td/h2"));
		System.out.println(elementOfTargetString.getText().toString());
		assertTrue(TARGET_TEXT.equals(elementOfTargetString.getText().toString()));	
	}
	
	@After
	public void exitBrowser() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
}
