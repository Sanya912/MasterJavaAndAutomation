import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//System.setProperty("webdriver.chrome.driver", C:\\chromedriver.exe);
		
		driver.get("https://www.amazon.com/");
		
		
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//*[@id=\'nav-link-accountList\']/span[2]"));
		
		
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		//move muse to specific element
		a.moveToElement(driver.findElement(By.xpath("//*[@id=\'nav-link-accountList\']/span[2]"))).contextClick().build().perform();
		
		
		
		
		
		

	}

}
