package tests;
import java.sql.Driver;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import productFunctions.Constants;
import productFunctions.F_Common;
import productFunctions.F_Verification;

import tests.TestBase;
public class AutoTest extends TestBase{
	
	@Test
	public void LoginPage() throws InterruptedException {
		driver.get("http://14.176.232.213:8084/");
		By Login= By.xpath("/html/body/header/div[1]/div/div[2]/ul/li[2]/a");
		F_Common.Click(driver, Login);
		By Username = By.name("email");
		F_Common.sendKeys(wait, driver, Username, "DuongChauSt46");
		By password = By.name("password");
		F_Common.sendKeys(wait, driver, password,"123456");
		By LoginBtn = By.xpath("//*[@id='Login_tab']/form/div[4]/input");
		F_Common.Click(driver, LoginBtn);
		
		//Search room
		
		By checkinIcn = By.id("check-in");
		F_Common.Click(driver, checkinIcn);
		By selectCheckinDay = By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[2]/a");
		F_Common.Click(driver, selectCheckinDay);
		By checkOutDay = By.xpath("/html/body/div[6]/table/tbody/tr[3]/td[4]/a");
		F_Common.Click(driver, checkOutDay);
		By adult = By.name("adult");
		F_Common.sendKeys(wait, driver, adult, "2");
		By child = By.name("children");
		F_Common.sendKeys(wait, driver, child, "2");
		By Search_btn = By.xpath("/html/body/section[1]/div/div/div/div/div/div/form/div[2]/div[3]/div/input");
		F_Common.Click(driver, Search_btn);
		
		//Select room page	
		
	By viewRoom = By.xpath("/html/body/section[2]/div/div/div[1]/div/div[2]/div/a");
		F_Common.scrollToEle(driver,viewRoom);
		F_Common.Click(driver, viewRoom);
	
		Thread.sleep(3000);
	
		
	}

}
