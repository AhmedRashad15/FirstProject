package testsPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Task3And4Tests {
    WebDriver driver;
    Wait<WebDriver> wait=new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(5))
            .pollingEvery(Duration.ofMillis(500))
            .ignoring(StaleElementReferenceException.class)
            .ignoring(NoSuchElementException.class)
            .ignoring(ElementNotInteractableException.class)
            .withMessage("Failed");

//    public WebElement fluentWait(By Locator){
//        Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
//                .withTimeout(Duration.ofSeconds(5))
//                .pollingEvery(Duration.ofMillis(500))
//                .ignoring(StaleElementReferenceException.class)
//                .ignoring(NoSuchElementException.class)
//                .ignoring(ElementNotInteractableException.class)
//                .withMessage("Failed");
//        WebElement foo=wait.until(Element -> driver.findElement(Locator));
//        return foo;
//    }
    @BeforeMethod
    public void setUp(){
        driver=new FirefoxDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1280 ,720));
        driver.navigate().to("https://duckduckgo.com/");
    }
    //Test Comment
    @Test
    public void task3(){

        By searchField=By.id("searchbox_input");
        driver.findElement(searchField).sendKeys("Selenium WebDriver",Keys.ENTER);
        By Link=By.xpath("(//article)[1]//h2/a");
        wait.until(d -> {
            driver.findElement(Link);
            String actualLink = driver.findElement(Link).getAttribute("href");
            Assert.assertEquals(actualLink, "https://www.selenium.dev/documentation/webdriver/");
            return true;
        });


    }
    @Test
    public void task4(){
        By searchField= By.id("searchbox_input");
        driver.findElement(searchField).sendKeys("TestNG",Keys.ENTER);

        By titleTestNG= By.xpath("(//article)[4]//h2//span");

        wait.until( d-> {
            driver.findElement(titleTestNG);
            SoftAssert softAssert = new SoftAssert();
            String actual = driver.findElement(titleTestNG).getText();
            softAssert.assertEquals("TestNG Tutorial", actual, "Assertion Failed");
            softAssert.assertAll();
            return true;
        });
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
