package TestPack_AssmtTask2;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.excelant.ExcelAntTest;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class Task2_FinalWorkingTC {
			private WebDriver driver;
			String filepath = "C:\\Pinks\\ReadExl12.xlsx";
//			String filepath = "ReadExl113.xlsx";
			String sheet112 = "AddUser111";
			ExcelAntTest eat111 = null; 
			@Test(dataProvider = "dp111")
			
			@DataProvider(name = "dp111")
			public Object[][] GetDataExl() throws Exception {
				Object[][] retObj111 = getRdData(filepath, sheet112);
				return(retObj111);
			}

			@Test
			public Object[][] getRdData(String filepath, String sheet112) throws Exception 
			{
				Object[][] data111 = null;
				FileInputStream fls111 = new FileInputStream(filepath);
				try {
				//Load the input stream to a workbook object//
				XSSFWorkbook wb111 = new XSSFWorkbook(filepath);
	 
				//Get the sheet from workbook by index//
				//XSSFSheet sheet111 = wb111.getSheet("AddUser111");
				XSSFSheet sheet111 = wb111.getSheet(sheet112);
	 
				//Count the total no. of Rows//
				int row111 = sheet111.getLastRowNum();
//				System.out.println("Total no. of Rows:" +row111);
	 
				//Count the total no. of Columns//
				int col111 = sheet111.getRow(1).getLastCellNum();
//				System.out.println("Total no. of Columns: " +col111);
				
				data111 = new Object[row111][col111];
	 
				//Read Data from sheet using Iteration method//
				for(int i = 0; i <row111; i++)
				{
									
						for(int j = 0; j <col111; j++)
						{
						//Store the cell value in the object//
						data111[i][j] = sheet111.getRow(i+1).getCell(j).toString();
//						System.out.println("Value of Data :" +data111[i][j]);		
						}	
				}
					wb111.close();	
					return data111;				
				}
				finally 
				{
			        // releases all system resources from the streams				
					fls111.close();
				}
			}
			@BeforeClass(alwaysRun = true)
			public void LaunchBrowser() throws Exception
			{
					System.setProperty("webdriver.gecko.driver","C:\\Pinks\\Selenium_Env\\DriversforBrowser\\geckodriver-v0.23.0-win64\\geckodriver.exe");
					driver = new FirefoxDriver();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
			  
					//Implicit Wait//
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
					// Maximize the window.
					driver.manage().window().maximize();
			}

			@Test(dataProvider = "dp111")
			public void testDataProviderExp(String Fn, String Ln, String Usn, String Pwd, String Cos, String Rol, String Eml, String Cell)throws Exception {

					//Check if Username is unique then add new user to the Table//
					if(driver.getPageSource().contains(Usn))
					{
						System.out.println("Username is not unique");
					}
					else {
						    	System.out.println("Username is unique and added to the Table");
				
						//Implicit Wait//
						driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			  						
				  //Click on Add User Button//
				  driver.findElement(By.cssSelector("body > table > thead > tr:nth-child(2) > td > button")).click(); 
				
				  //Clear the Firstname Field//
				  driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(1) > td:nth-child(2) > input")).clear();	
				  //Enter the First Name//
				  driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(1) > td:nth-child(2) > input")).sendKeys(Fn);
				  
				  //Clear the Lastname Field//
				  driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(2) > td:nth-child(2) > input")).clear();
				  //Enter the Last Name//
				  driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(2) > td:nth-child(2) > input")).sendKeys(Ln);
				  
				  //Clear the User name Field//
				  driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(3) > td:nth-child(2) > input")).clear();
				  //Enter the User Name//
				  driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(3) > td:nth-child(2) > input")).sendKeys(Usn);
				  
				  //Clear the Password Field//
				  driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(4) > td:nth-child(2) > input")).clear();
				  //Enter the Password//
				  driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(4) > td:nth-child(2) > input")).sendKeys(Pwd);

				  //Check if the value of Customer and then click//
				  if(Cos == "Company AAA")
				  {
					  	driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(5) > td:nth-child(2) > label:nth-child(1) > input")).click();
//					  	System.out.println("Value of Company AAA :" +Cos);
				  }
				  else
				  {
					  	driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(5) > td:nth-child(2) > label:nth-child(2) > input")).click();
//					  	System.out.println("Value of Company BBB :" +Cos);
				  }
				  //Enter the Role//
				  driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(6) > td:nth-child(2) > select")).sendKeys(Rol);
				  
				  //Clear the Email Field//
				  driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(7) > td:nth-child(2) > input")).clear();
				  //Enter the Email//
				  driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(7) > td:nth-child(2) > input")).sendKeys(Eml);
				  
				  //Clear the Cell phone Field//
				  driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(8) > td:nth-child(2) > input")).clear();
				  //Enter the Cell Phone//
				  driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-body > form > table > tbody > tr:nth-child(8) > td:nth-child(2) > input")).sendKeys(Cell);

				  driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
				  
				  //Click on the "Save" Button//
				  driver.findElement(By.cssSelector("body > div.modal.ng-scope > div.modal-footer > button.btn.btn-success")).click();
			        
				  driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
				  
				}		  
//				  driver.close();
			}  
	}