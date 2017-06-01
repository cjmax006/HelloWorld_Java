package auto_neo;

import java.util.ArrayList;
import java.util.Scanner;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Neobux_click {

	public static void main(String[] args) {	
//>>>>>---------------------- Login Function --------------------------------------------------
					/*String Chrome_Profile_Path = "C:\\Users\\Chandan Jha\\AppData\\Local\\Google\\Chrome\\User Data";
					ChromeOptions Chrome_Profile = new ChromeOptions();
					Chrome_Profile.addArguments("chrome.switches","--disable-extensions"); 
					Chrome_Profile.addArguments("user-data-dir=" + Chrome_Profile_Path);
		
		WebDriver driver = new ChromeDriver(Chrome_Profile);
		*/
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		//WebDriver driver = new ChromeDriver();
		driver.get("https://www.neobux.com");
		driver.findElement(By.xpath("//*[text()='Login']")).click();
		driver.findElement(By.xpath("//*[@id='Kf1']")).sendKeys("cjmaxx006");
		driver.findElement(By.xpath("//*[@id='Kf2']")).sendKeys("Tester@123");
				
		//If verification code field is available ----------------------------------------------------
		try
			{
		 		boolean vcode=driver.findElement(By.xpath("//*[@id='Kf0']/tbody/tr[1]/td[1]/table/tbody/tr[4]/td[1]")).isDisplayed();
		 		//System.out.println("verification code is displyed: " + vcode);
							if(vcode==true)
								{	System.out.println("Verification code is asked to login");
									@SuppressWarnings("resource")
											Scanner reader=new Scanner(System.in);
											System.out.println("Enter the verification code: ");
											String vstring=reader.next();
											driver.findElement(By.xpath("//*[@id='Kf3']")).sendKeys(vstring);
															}
																	}
				catch(Exception e)
						{
							System.out.println("verification code is not displyed");
									}
//--------------------------------------------------------------------------------------------
		driver.findElement(By.xpath("//*[@id='botao_login']")).click();		
//>>>>>----------------- End Login Function --------------------------------------------------		
		driver.findElement(By.xpath("//*[@id='nav_of']/preceding::a[@class='button green']")).click();		
		
//---------------------OPEN - click to Purple advertisements ------------------------------------------------------------------
	 try
	 {
		boolean p_code=driver.findElement(By.xpath("//*[@class='button small2 purple']//span")).isDisplayed();
		if(p_code==true)
		{
		String p_count=driver.findElement(By.xpath("//*[@class='button small2 purple']//span")).getText();
		int PurpleAdCount=Integer.valueOf(p_count);
		
		System.out.println("Purple ad count is: " + PurpleAdCount);		
		driver.findElement(By.xpath("//*[@class='button small2 purple']//span")).click();
		//driver.findElement(By.xpath("//span[text()='View Advertisements']")).click();
								
			for(int Ad_pcount=1;Ad_pcount<=PurpleAdCount;Ad_pcount++) {
				String adbox="//*[@id='l0l"+Ad_pcount+"']/tbody/tr[1]/td";
				String adreddot="//*[@id='i"+Ad_pcount+"']";
						driver.findElement(By.xpath(adbox)).click();
						driver.findElement(By.xpath(adreddot)).click();
				
				ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(newTab.get(1));
						//String gTitle=driver.getTitle();
						//System.out.println(gTitle);
				//Place an explicit wait to click and close the advertisement
				new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='o1']//a[@class='button small2 orange']")));
				System.out.println("Advertisement Number ( " + Ad_pcount + " ) is clicked and loaded !!");
				driver.findElement(By.xpath("//*[@id='o1']//a[@class='button small2 orange']")).click();
				driver.switchTo().window(newTab.get(0));				
						}	//finish the loop for purple ads
					} 
	 		}
		catch(Exception e){
					System.out.println("There are no purple Ads available today !!!");
				}
		//---------------------Closed - click to Purple advertisements ----------------------------------------------------------------
		
		//---------------------OPEN - click to Orange advertisements ------------------------------------------------------------------
	try
	{
	  	boolean o_code=driver.findElement(By.xpath("//*[@class='button small2 orange']/span")).isDisplayed();
	
		if(o_code==true)
		{
		String o_count=driver.findElement(By.xpath("//*[@class='button small2 orange']/span")).getText();
		int OrangeAdCount=Integer.valueOf(o_count);
		
		driver.findElement(By.xpath("//*[@class='button small2 orange']")).click();
		System.out.println("Orange ad count is: " + OrangeAdCount);
		
		// code to click the orange ads ----
				for(int Ad_ocount=1;Ad_ocount<=OrangeAdCount;Ad_ocount++) {
						String adbox="//a[@id='tga_2"+Ad_ocount+"']";
						String adreddot="//img[@id='i2"+Ad_ocount+"']";
								driver.findElement(By.xpath(adbox)).click();
								driver.findElement(By.xpath(adreddot)).click();
						
						ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().window(newTab.get(1));
								//String gTitle=driver.getTitle();
								//System.out.println(gTitle);
						//Place an explicit wait to click and close the advertisement
						new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='o1']//a[@class='button small2 orange']")));
						System.out.println("Advertisement Number ( " + Ad_ocount + " ) is clicked and loaded !!");
						driver.findElement(By.xpath("//*[@id='o1']//a[@class='button small2 orange']")).click();
						driver.switchTo().window(newTab.get(0));						
				}
					} }
			catch(Exception e){
				System.out.println("There are no orange Ads available today !!!");
			}
	
			//---------------------CLOSED - click to Orange advertisements --------------------------------------------------------------
			
			/*	//---------------------OPEN - click to gray advertisements ------------------------------------------------------------------
			try
			{
				boolean g_code=driver.findElement(By.xpath("//a[@href='#ad_5']/span")).isDisplayed();
				if(g_code==true)
				{
				String g_count=driver.findElement(By.xpath("//a[@href='#ad_5']/span")).getText();
				int GrayAdCount=Integer.valueOf(g_count);
				
				driver.findElement(By.xpath("//a[@href='#ad_5']")).click();
				System.out.println("Gray ad count is: " + GrayAdCount);
				
				// code to click the orange ads ----
						for(int Ad_gcount=1;Ad_gcount<=GrayAdCount;Ad_gcount++) {
							int AdNo = 18 + Ad_gcount;
								String adbox="//a[@id='tga_"+AdNo+"']";
								String adreddot="//img[@id='i"+AdNo+"']";
										driver.findElement(By.xpath(adbox)).click();
										driver.findElement(By.xpath(adreddot)).click();
								
								ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
								driver.switchTo().window(newTab.get(1));
										//String gTitle=driver.getTitle();
										//System.out.println(gTitle);
								//Place an explicit wait to click and close the advertisement
								new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='o1']//a[@class='button small2 orange']")));
								System.out.println("Advertisement Number ( " + Ad_gcount + " ) is clicked and loaded !!");
								driver.findElement(By.xpath("//*[@id='o1']//a[@class='button small2 orange']")).click();
								driver.switchTo().window(newTab.get(0));						
						}
					}	
						}
					catch(Exception e){
								System.out.println("There are no gray Ads available today !!");
										}
		//---------------------CLOSED - click to gray advertisements ----------------------------------------------------------		
			*/
		driver.findElement(By.xpath(".//*[@id='ubar_w1']//td[3]/a/span")).click();
		driver.close();
		//System.exit(0);			
		}

	}