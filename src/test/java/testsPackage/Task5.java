package testsPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task5 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1280 ,720));
        driver.navigate().to("https://duckduckgo.com/");
    }

    public WebElement fluentWait(By Locator){
        Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .withMessage("Failed");
        WebElement foo=wait.until(Element -> driver.findElement(Locator));
        return foo;
    }
    @Test
    public void searchForLink(){
        By searchField=By.id("searchbox_input");
        fluentWait(searchField);
        driver.findElement(searchField).sendKeys("Cucumber IO");
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
