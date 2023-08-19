package com.qa.opencart.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
public class LoginPage 
{
	private WebDriver driver;
	private ElementUtil ele;
	//Private By Locator:
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	
	//page const
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		ele = new ElementUtil(driver);
	}
	
	//3.page actions/method
	public String getLoginPageTitle()
	{
		String title=driver.getTitle();
		System.out.println("login title : "+title);
		return title;
	}
	public String getLoginPageUrl()
	{
//		String url = driver.getCurrentUrl();
//		System.out.println("login page url : "+url);
//		return url;
		String url=ele.waitForURLContainsAndFetch(AppConstants.DEFAULT_MEDIUM_TIME_OUT, "AppConstants.LOGIN_PAGE_TITLE_VALUE");
		System.out.println("login page url "+ url);
		return url;
	}
//	public boolean isForgotPwdLibkExist1()
//	{
//		//return ((WebElement) ele.waitForElementsVisible(forgotPwdLink, 10)).isDisplayed();
//	}
	public AccountsPage doLogin(String un, String pwd)
	{
		((WebElement) ele.waitForElementsVisible(emailId, 10)).sendKeys(un);
		//driver.findElement(emailId).sendKeys(un);
		ele.doSendKeys(password, pwd);
		//driver.findElement(password).sendKeys(pwd);
		ele.doClick(loginBtn);
		//driver.findElement(loginBtn).click();
		return new AccountsPage(driver);
	}

	public boolean isForgotPwdLibkExist() {
		// TODO Auto-generated method stub
		return false;
	}
}
