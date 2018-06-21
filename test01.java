package test01;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

import net.bytebuddy.description.field.FieldDescription.Token;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.NoSuchWindowException;
public class test01 {
private static CharSequence[] Vishal;

public static void main(String[] args)throws InterruptedException{
	
	System.setProperty("webdriver.chrome.driver", "D:\\Vishal\\back\\installed\\chromedriver.exe");
	WebDriver I = new ChromeDriver();
	I.get("http://10.0.1.86/tatoc");
	
	//basic course
	I.findElement(By.cssSelector("a")).click();
	
	//problem1
	I.findElement(By.className("greenbox")).click();
	
	//Thread.sleep(2000);
	
	//problem1
	
	
	
	
	
	I.switchTo().frame("main");
	String box1 = I.findElement(By.id("answer")).getAttribute("class");
	while(true)
	{
		I.findElement(By.cssSelector("a")).click();
		I.switchTo().frame("child");
		String box2 = I.findElement(By.id("answer")).getAttribute("class");
		I.switchTo().parentFrame();
		if(box1.equals(box2))
			{
			//I.findElement(By.linkText("Proceed")).get().click();
			WebElement w = (WebElement)I.findElements(By.cssSelector("a")).get(1);
			w.click();//cant access c:/jre properly on my system 
			break;
			}
	}
	
	
	//problem3
	WebElement from = I.findElement(By.id("dragbox"));
	WebElement to   = I.findElement(By.id("dropbox"));
	Actions act     = new Actions(I);
	act.dragAndDrop(from, to).build().perform();
	I.findElement(By.linkText("Proceed")).click();
	
	
	
	//problem4
	I.findElement(By.linkText("Launch Popup Window")).click();
	ArrayList<String> WindowNames = new ArrayList<String> (I.getWindowHandles());	
	I.switchTo().window(WindowNames.get(1));
	I.findElement(By.id("name")).sendKeys("abc");
	I.findElement(By.id("submit")).click();
	I.switchTo().window(WindowNames.get(0));
	I.findElement(By.linkText("Proceed")).click();
	
	
	
	//problem5
	I.findElement(By.linkText("Generate Token")).click();
	String token = I.findElement(By.id("token")).getText();
	String[] splited = token.split("\\s+");
	Cookie token1 = new Cookie("Token", splited[1]);
	I.manage().addCookie(token1);
	Thread.sleep(1000);
	I.findElement(By.linkText("Proceed")).click();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    	
	
	
	
	
}
	
	
}
