package test;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pagesfactory.TestFire;


public class TestTestFireWithPageFactory {

	WebDriver driver;
	TestFire objLogin;
	
	@Before
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "E:/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.testfire.net/login.jsp");
	}

	
	/**
	 * 	1.	打开登录页面 http://www.testfire.net/login.jsp
			2.  使用用户名admin，密码admin登录；
			3.	验证登录后的main页面上有字符串“Congratulations!”
	 */
	@Test
	public void test_Login(){
		//Create Login Page object
	objLogin = new TestFire(driver);
	
	//登录操作
	objLogin.loginToTestfire("admin", "admin");
	
	//将选择器里的文本与指定文本进行对比
	String targetText = objLogin.getTargetText();
	Assert.assertTrue("Congratulations!".equals(targetText.toString()));
	}
	
	@After
	public void exitBrowser() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//3秒之后退出浏览器
		driver.quit();
	}
}
