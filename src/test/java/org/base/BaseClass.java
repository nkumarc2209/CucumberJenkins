package org.base;

import java.awt.AWTException;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public  class BaseClass {
	
	  public static WebDriver driver;
	
  //1 - Browser launch
	 public  static void browerLaunch(String url) {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
    	}	
	 
  //2 - Browser close
	 public  static void browserQuit() {
//		driver.close(); //---> close the current browser window
       driver.quit();   //---> close all the browser window
		}	
	 
	 public  static void browserClose() {
		 driver.close();
	 }
	 
  //3 - Navigate browser
	 public static void navigateBrowser(String url) {
		driver.navigate().to(url);
	    }
	 
  //4 - get Title
	 public static String getTitle() {
		return driver.getTitle();
		}
	 
  //5 - Navigate back 
     public static void navigateBack() {
    	driver.navigate().back();
    	} 
     
  //6 - Navigate forward
     public static void navigateForward() {
    	driver.navigate().forward();
    	} 
     
  //7 - get current url
     public static String currentUrl(String url) {
        return driver.getCurrentUrl();
        }  
     
  //8 - find Element by ID 
     public static WebElement findElementByID(String id) {
    	WebElement elementid = driver.findElement(By.id(id));
    	return elementid;
    	} 
     
  //9 - find element by xpath  
     public static WebElement findElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
        }  
     
  //10 - find element by Name  
     public static WebElement findElementByName(String name) {
        return driver.findElement(By.name(name));
        }    
  //11 - find element by ClassName 
     public static WebElement findElementByClass(String classname) {
        return driver.findElement(By.className(classname));
        } 
     
  //12 - find element by CssSelector 
     public static WebElement findElementByCssSelector(String css) {
    	return driver.findElement(By.cssSelector(css));
    	} 
     
  //13 - send value 
     public static void sendValue(WebElement element , String data) {
     //public static void sendValue(By locator , String value) {
     //driver.findElement(locator).sendKeys(value);
         element.clear();
         element.sendKeys(data);
		 }
    
  //14 - click element
     public static void clickElement(By locator ) {
        driver.findElement(locator).click();
         }
     
  //15 - clear element
     public static void clearElement(WebElement element) { 
        element.clear();   //---> to remove the existing text in the input field
	     }
     
  //16 - Alert --> Simple alert 
     public static void acceptAlert() {
    	driver.switchTo().alert().accept();
	     }
     
  //17 - Alert --> Confirmation alert 
     public static void dismissAlert() {
    	driver.switchTo().alert().dismiss();
	     }
     
  //18 - alert.getText 
     public static String getTextAlert() {
        return driver.switchTo().alert().getText();
	     }
     
  //19 - alert.sendKeys
     public static void alertSendKeys(String text) {
    	driver.switchTo().alert().sendKeys(text);
	     }
     
  //20 - slert.getText Alert -->Prompt alert 
     public static void alertEnterAndAccept(String text) {
        Alert alert = driver.switchTo().alert();  
        alert.sendKeys(text);
        alert.getText();
        alert.accept();
	     }
     
  //21 - Frame --> switch to
    public static void switchToFrameByIDorName(String IdorName,String Id) {
         driver.switchTo().frame(IdorName);
         driver.findElement(By.id(Id)).click();         
	     }   
    
  //22 - frame --> by Index 
    public static void switchToFrameByIndex(int index) {
    	driver.switchTo().frame(index);
	     }
    
  //23 - Frame --> default 
    public static void switchToDefault() {
    	driver.switchTo().defaultContent();        
	     }
    
  //24 - Dropdown --> selectby Visible text
    public static void selectByVisibleText(By locator, String text) {
    	Select select = new Select(driver.findElement(locator));
    	select.selectByVisibleText(text); 
	     }
    
  //25 - Dropdown --> select by Index
    public static void selectByIndex(WebElement element,int index) {
    	Select select = new Select(element);
    	select.selectByIndex(index);
	     }
    
  //26 - Actions --> move to element 
    public static void mouseHover(WebElement element) {
    	Actions action = new Actions(driver);
    	action.moveToElement(element).perform();
	     }
    
  //27 - Actions --> context click
    public static void rightClick(By locator) {
    	Actions action = new Actions(driver);
    	action.contextClick(driver.findElement(locator)).perform();
	     }
    
  //28 - Actions --> Drag and Drop
    public static void dragAndDrop(By locator,By locator1) {
    	Actions action = new Actions(driver);
    	action.dragAndDrop(driver.findElement(locator),driver.findElement(locator1)).perform();
	     }
    
  //29 - Javascript --> scrolldown	
    public static void javascriptScroll(WebElement element,boolean condition) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView("+ condition +")",element);
	     }
    
  //30 - Screenshot 
    public static void Screenshot(String filename) throws IOException {
    	TakesScreenshot ts = (TakesScreenshot) driver;
    	File source = ts.getScreenshotAs(OutputType.FILE);
    	File dest = new File("C:\\Users\\Vishnu\\OneDrive\\Desktop\\screenshots\\"+ filename +".png");
    	FileUtils.copyFile(source, dest);
	     }
    
  //31 - Robot class
    public static void robotMethod(int count) throws AWTException, InterruptedException {
    	Robot robot = new Robot();
    	for (int i = 0; i < count; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(1000);
            robot.keyRelease(KeyEvent.VK_TAB);		
    	}
    }
    	
  //32 - DataDriven
    	public static String getDataFromExcel(String filename1, String sheetname,
                int row, int cell) throws IOException {
    		
    		File excelfile = new File(filename1);

    		FileInputStream fileinputstream = new FileInputStream(excelfile);

    		Workbook workbook = new XSSFWorkbook(fileinputstream);

    		Sheet sheet = workbook.getSheet(sheetname);

    		Row excelrow = sheet.getRow(row);

    		Cell excelcell = excelrow.getCell(cell);

    		String value = excelcell.toString();

    		return value;

}
  	
    }






