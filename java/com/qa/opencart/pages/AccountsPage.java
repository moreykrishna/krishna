package com.qa.opencart.pages;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;
public class AccountsPage
{
	WebDriver driver;
	private ElementUtil ele;
	private By logoutLink = By.linkText("Logout");
	private By accHeaders = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("#search button");
	
	public AccountsPage(WebDriver driver)
	{
		this.driver=driver;
		ele = new ElementUtil(driver);
	}
	public String getAccPageTitle()
	{
		String title= driver.getTitle();
		System.out.println("Acc page Title : "+title);
		return title;
	}
	
	public String getAccPageURL()
	{
		String url = driver.getCurrentUrl();
		System.out.println("Acc page url : "+url);
		return url;
	}
	public boolean isLogoutLinkExist()
	{
		return driver.findElement(logoutLink).isDisplayed();
	}
	public boolean isSearchExist()
	{
		return ele.waitForElementVisible(search, 10).isDisplayed();
		
	}
	
	public List<String> getAccountsPageHeadersList()
	{
		List<WebElement> accHeadersList = driver.findElements(accHeaders);
		List<String> accHeaderValList=new ArrayList<String>();
		for(WebElement e : accHeadersList)
		{
			String text=e.getText();
			accHeaderValList.add(text);
		}
		return accHeaderValList;
	}

public SearchPage performSearch(String searchKey) {
		
		if(isSearchExist()) {
			ele.doSendKeys(search, searchKey);
			ele.doClick(search);
			return new SearchPage(driver);
		}
		else {
			System.out.println("Search field is not present on the page....");
			return null;
		}
		
	}
	
	
	
	

}
