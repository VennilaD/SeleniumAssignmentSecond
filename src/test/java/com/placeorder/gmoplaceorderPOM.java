package com.placeorder;

import org.testng.annotations.Test;

import com.pages.gmoonline;
import com.utility.Constants;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class gmoplaceorderPOM extends Library{
	
	
  @Test(priority=0)
  public void GmoOnlineLoaded() {
	  
	  System.out.println("inside GmoOnlineLoaded");
	 String titleOfGmoOnline = driver.getTitle();
	 System.out.println("titleOfGmoOnline:"+titleOfGmoOnline);
	 Assert.assertEquals(titleOfGmoOnline, objProperties.getProperty("GmoOnlineTitle"));
	
	 
  }
	 
	
	 @SuppressWarnings("deprecation")
	@Test(priority=1,dependsOnMethods= {"GmoOnlineLoaded"})
	   public void ValidateEnterGmoOnline() {
	 	  	driver.findElement(gmoonline.Entergmoonline).click();
	 	  	driver.manage().timeouts().pageLoadTimeout(Constants.pageLoadTimeOut,TimeUnit.SECONDS);
	 		driver.findElement(gmoonline.clearingglassesindexbox).clear();
	 	  	driver.findElement(gmoonline.enteringquantityofglasses).sendKeys(Constants.QuantityOfSunGlasses);
	 		driver.findElement(gmoonline.clickplacetheorder).click();
	 		String titleofplaceorder=driver.getTitle();
	 		System.out.println("titleofplaceorder: "+titleofplaceorder);
	 		Assert.assertEquals(titleofplaceorder, objProperties.getProperty("placeordertitle"));
	 		
	 		String glassprice=driver.findElement(gmoonline.unitpriceofsunglasses).getText().substring(2);
	 		System.out.println("glassprice: "+glassprice);
	 		Float threeglassprice=Float.parseFloat(glassprice)*Integer.parseInt(Constants.QuantityOfSunGlasses);
	 		System.out.println("threeglassprice :"+threeglassprice);
	 		
	 		String applicationthreeglassprice=driver.findElement(gmoonline.priceofsunglassesfromapplication).getText().substring(2);
	 		Float fromapplicationthreeglassprice=Float.parseFloat(applicationthreeglassprice);
	 		System.out.println("fromapplicationthreeglassprice:"+fromapplicationthreeglassprice);
	 		Assert.assertEquals(threeglassprice, fromapplicationthreeglassprice);
	 
	 		String producttotal=driver.findElement(gmoonline.producttotalvalue).getText().substring(2);
	 		System.out.println("producttotal:"+producttotal);
	 		Float valueofproducttotal=Float.parseFloat(producttotal);
	 

	 	
	 		String salestax=driver.findElement(gmoonline.salestaxvalue).getText().substring(2);
	 		System.out.println("salestax:"+salestax);
	 		Float valueofsalestax=Float.parseFloat(salestax);
	 		
	 		String shippingandhandling=driver.findElement(gmoonline.shippinghandlingvalue).getText().substring(2);
	 		System.out.println("shippingandhandling:"+shippingandhandling);
	 		Float valueofshippingandhandling=Float.parseFloat(shippingandhandling);
	 		
	 		Float total=Float.parseFloat(producttotal)+Float.parseFloat(salestax)+Float.parseFloat(shippingandhandling);
	 		System.out.println("total :"+total);
	 		
	 		
	 		String applicationgrandtotal=driver.findElement(gmoonline.applicationgrandtotalvalue).getText().substring(2);
	 		System.out.println("applicationgrandtotal :"+applicationgrandtotal);
	 		Float valueofapplicationgrandtotal=Float.parseFloat(applicationgrandtotal);
	 		
	 		Assert.assertEquals(valueofapplicationgrandtotal,total);
	 		
	 		
	 }

	
	 		
	
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  Library.LaunchBrowser();
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("insite beforeSuite");
	  try {
		ReadPropertiesFile();
	} catch (Exception e) {
	
		e.printStackTrace();
  }
  }
  @AfterSuite
  public void afterSuite() {
  }

}
