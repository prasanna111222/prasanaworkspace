package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Library {

	WebDriver driver;
	String Expval,Actval;
	FileInputStream FIS;
	Properties PR;
		
		
		public void openApp(String Url) throws IOException
		{

			FIS=new FileInputStream("C:\\Seleniumproject\\Ebanking\\src\\com\\ebanking\\properties\\Rep.properties");
			PR=new Properties();
			PR.load(FIS);
			Expval = "Ranford Bank";		
			
			//Launch Browser
			System.setProperty("webdriver.chrome.driver","C:\\Users\\prass\\OneDrive\\Desktop\\chromedriver.exe");
		    driver=new ChromeDriver();
			
			//Url
			
			//driver.get("http://183.82.100.55/ranford2");
			driver.get(Url);
			
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
			


		}
		
		public void AdminLgn(String Un,String Pwd) throws InterruptedException
		{
			
			Thread.sleep(3000);
			driver.findElement(By.id(PR.getProperty("Uname"))).sendKeys(Un);
			driver.findElement(By.id(PR.getProperty("Pswd"))).sendKeys(Pwd);
			driver.findElement(By.xpath(PR.getProperty("Lgn"))).click();
			
			Expval="Welcome to Admin";
		    Actval =driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();		
			
			if(Actval.equalsIgnoreCase(Expval))
			{
				System.out.println("Admin Page is Launched");
			}
			else
			{
				System.out.println("Admin Page is Not Launched");
			}
		}
		
		public void BranchCre(String BName,String Add1,String Add2,String Add3,String Area,String Zip,String Cntry,String Ste,String Cty)
		{
			driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")).click();
			driver.findElement(By.id(PR.getProperty("Bbtn"))).click();
			
			//branchname
			driver.findElement(By.name(PR.getProperty("BNme"))).sendKeys(BName);
			
			//Add 1
			driver.findElement(By.id(PR.getProperty("BAddress1"))).sendKeys(Add1);
			
			driver.findElement(By.id(PR.getProperty("BAddress2"))).sendKeys(Add2);
			driver.findElement(By.id(PR.getProperty("BAddress3"))).sendKeys(Add3);
			
			
			driver.findElement(By.id(PR.getProperty("BAra"))).sendKeys(Area);
			
			//Zipcode
			driver.findElement(By.id(PR.getProperty("BZp"))).sendKeys(Zip);
			//Country
			
			Select Ctry=new Select(driver.findElement(By.id(PR.getProperty("BCountry"))));
			Ctry.selectByVisibleText(Cntry);
			
			//State
			Select State= new Select(driver.findElement(By.name(PR.getProperty("BState"))));
			State.selectByVisibleText(Ste);
			
			//city
			
			Select City= new Select(driver.findElement(By.id(PR.getProperty("BCity"))));
			City.selectByVisibleText(Cty);
			
			//submit
			driver.findElement(By.id(PR.getProperty("BSubmit"))).click();
			
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

		}
		
		
		  public void HomebtnClick()
		  {
		    //Home button
			driver.findElement(By.xpath("//*[@id=\"Table_01\"]/tbody/tr/td[1]/a/img")).click();
		  }
		  
		  public void  RoleCrea(String RoleName,String RoleDesc,String RoleType) throws InterruptedException
		  {
				//Role creation
			driver.findElement(By.xpath("//*[@id=\"Table_01\"]/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
				
			driver.findElement(By.xpath(PR.getProperty("BRole"))).click();
			Thread.sleep(3000);
				
		    driver.findElement(By.xpath(PR.getProperty("RNamee"))).sendKeys(RoleName);
		   
				
			driver.findElement(By.xpath(PR.getProperty("RDesc"))).sendKeys(RoleDesc);
				
			Select Roletype= new Select(driver.findElement(By.xpath(PR.getProperty("RType"))));
			Roletype.selectByVisibleText("E");
				
			driver.findElement(By.xpath(PR.getProperty("Rsubmit"))).click();
				
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
						
		  }	
		  
		  public void EmpCrtn(String EmpName,String Password,String Rolee,String Branchh) throws InterruptedException
		  {
				//Emp creation
				
				driver.findElement(By.xpath("//*[@id=\"Table_01\"]/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")).click();
				
				driver.findElement(By.id(PR.getProperty("BEmp"))).click();
				
				driver.findElement(By.name(PR.getProperty("EName"))).sendKeys(EmpName);
				
				driver.findElement(By.name(PR.getProperty("EPwd"))).sendKeys(Password);
				
				Select Role=new Select(driver.findElement(By.name(PR.getProperty("ERole"))));
				Role.selectByVisibleText(Rolee);
				
				
				Select Branch= new Select(driver.findElement(By.xpath(PR.getProperty("EBranch"))));
				Branch.selectByVisibleText(Branchh);
				
				driver.findElement(By.name(PR.getProperty("ESubmit"))).click();
				
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
				
		  }
				
		  public void CloseApp()
		  {
				//close Application
				driver.quit();
		  }

		
}
		
		
		



