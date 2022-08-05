package com.utility;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Library {
	
	public static Properties objProperties ;
	public static WebDriver driver;

	public static void ReadPropertiesFile() {
		System.out.println("location of project:" + System.getProperty("user.dir"));
		
		try {
			
			FileInputStream ObjInputStream= new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//config.properties");
			
			objProperties = new Properties();
		
			objProperties.load(ObjInputStream);
		
			System.out.println(objProperties.getProperty("browser"));
			System.out.println(objProperties.getProperty("GmoOnlineURL"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
}
	public static void LaunchBrowser() {
	String browserFromPropertiesFile = objProperties.getProperty("browser");
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.get(objProperties.getProperty("GmoOnlineURL"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


}
	
	
		
	
}
