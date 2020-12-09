



package com.ebanking.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

public class Basic {

	public static void main(String[] args) throws InterruptedException
	{ 
		String Expval = "Ranford Bank";		
	
		//Launch Browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\prass\\OneDrive\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//Url
		
		//driver.get("http://183.82.100.55/ranford2");
		driver.get("http://122.175.8.158/ranford2/");
		
		//Maximise
		
		driver.manage().window().maximize();
		
		String Actval= driver.findElement(By.xpath("//*[@id=\"Form1\"]/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
		
		if(Expval.equalsIgnoreCase(Actval))
		{
			System.out.println("Application Launch");
		}
		else
		{
			System.out.println("Application Not Launch");
		}
		
		Thread.sleep(3000);
		
		//Admin login
		
		uikl./
		
		//Branches
		
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")).click();
		driver.findElement(By.id("BtnNewBR")).click();
		
		//branchname
		driver.findElement(By.name("txtbName")).sendKeys("Branch99");
		
		//Add 1
		driver.findElement(By.id("txtAdd1")).sendKeys("Address99");
		
		driver.findElement(By.id("Txtadd2")).sendKeys("Address991");
		driver.findElement(By.id("txtadd3")).sendKeys("Address992");
		
		
		driver.findElement(By.id("txtArea")).sendKeys("Area99");
		
		//Zipcode
		driver.findElement(By.id("txtZip")).sendKeys("300078");
		//Country
		
		Select Ctry=new Select(driver.findElement(By.id("lst_counrtyU")));
		Ctry.selectByVisibleText("INDIA");
		
		//State
		Select State= new Select(driver.findElement(By.name("lst_stateI")));
		State.selectByVisibleText("GOA");
		
		//city
		
		Select City= new Select(driver.findElement(By.id("lst_cityI")));
		City.selectByVisibleText("GOA");
		
		//submit
		driver.findElement(By.id("btn_insert")).click();
		
		Expval = "Successfully";
		Actval = driver.switchTo().alert().getText();
		
		//Alert
		
		driver.switchTo().alert().accept();
		
		if(Actval.contains(Expval))
		{
			System.out.println("New Branch is Created Successfully");
		}
		else
		{
			System.out.println("New Branch is Not Created Successfully");
		}
		
		//Home button
		driver.findElement(By.xpath("//*[@id=\"Table_01\"]/tbody/tr/td[1]/a/img")).click();
		
		//Role creation
		driver.findElement(By.xpath("//*[@id=\"Table_01\"]/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
		
		driver.findElement(By.id("btnRoles")).click();
		
		driver.findElement(By.name("txtRname")).sendKeys("AssistantManagerr");
		
		driver.findElement(By.name("txtRDesc")).sendKeys("ManagerrDesc");
		
		Select Roletype= new Select(driver.findElement(By.name("lstRtypeN")));
		Roletype.selectByVisibleText("E");
		
		driver.findElement(By.name("btninsert")).click();
		
		Expval = "Successfully";
		Actval = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		
		if(Actval.contains(Expval))
		{
			System.out.println("New Role is Created Successfully");
		}
		else
		{
			System.out.println("New Role is Not Created Successfully");
		}
		
		
		driver.findElement(By.xpath("//*[@id=\"Table_01\"]/tbody/tr/td[1]/a/img")).click();
		
		
		//Emp creation
		
		driver.findElement(By.xpath("//*[@id=\"Table_01\"]/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")).click();
		
		driver.findElement(By.id("BtnNew")).click();
		
		driver.findElement(By.name("txtUname")).sendKeys("EmployeeeEmployee");
		
		driver.findElement(By.name("txtLpwd")).sendKeys("pwdpwd");
		
		Select Role=new Select(driver.findElement(By.name("lst_Roles")));
		Role.selectByVisibleText("assistantmanager");
		
		
		Select Branch= new Select(driver.findElement(By.name("lst_Branch")));
		Branch.selectByVisibleText("bridgeq");
		
		driver.findElement(By.name("BtnSubmit")).click();
		
		Expval = "Successfully";
		Actval = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		
		
		if(Actval.contains(Expval))
		{
			System.out.println("New Employee is Created Successfully");
		}
		else
		{
			System.out.println("New Employee is Not Created Successfully");
		}
		
		//
		//Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"Table_01\"]/tbody/tr/td[1]/a/img")).click();
		
		Thread.sleep(3000);
		//Log out
		driver.findElement(By.xpath("//*[@id=\"Table_02\"]/tbody/tr/td[3]/a/img")).click();
		 
		Expval = "Ranford Bank";
		Actval= driver.findElement(By.xpath("//*[@id=\"Form1\"]/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();		
		
		if(Actval.equalsIgnoreCase(Expval))
		{
			System.out.println("Application Logout sucessfully");
		}
		else
		{
			System.out.println("Application not Logout sucessfully");
		}
		
		
		//close Application
		driver.quit();
		
	}

}
