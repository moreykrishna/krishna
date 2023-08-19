package com.qa.opencart.factory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class DriverFactory 
{
	public WebDriver driver;
	public Properties prop;
	public static String highlight;
	
	public WebDriver initDriver(Properties prop)
	{
		optionsManager = new OptionsManager(prop);
		highlight = prop.getProperty("highlight").trim();
		String browserName=prop.getProperty("browser").toLowerCase().trim();
		System.out.println("browser name is : "+ browserName);
		if(browserName.trim().equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browserName.trim().equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browserName.trim().equalsIgnoreCase("safari"))
		{
			driver= new ChromeDriver();
		}
		else if(browserName.trim().equalsIgnoreCase("edge"))
		{
			driver= new ChromeDriver();
		}
		else
		{
			System.out.println("plz pass the right browser ...."+ browserName);
		}
		driver.manage().deleteAllCookies();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;
	}
	//this method reading properties from .properties file
	public Properties initProp() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;

}}
