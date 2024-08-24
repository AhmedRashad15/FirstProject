package testsPackage.linear;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import duckDuckGoPages.Landing;
import duckDuckGoPages.SearchResult;

import java.time.Duration;

public class Task5 {
    WebDriver driver;
    Landing landingPage;
    SearchResult searchResultPage;
    Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(5))
            .pollingEvery(Duration.ofMillis(500))
            .ignoring(StaleElementReferenceException.class)
            .ignoring(NoSuchElementException.class)
            .ignoring(ElementNotInteractableException.class)
            .ignoring(AssertionError.class)
            .ignoring(TimeoutException.class)
            .withMessage("Failed");




    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1280 ,720));
        landingPage=new Landing(driver);
        searchResultPage=new SearchResult(driver);
        landingPage.navigate();
        }

//    public WebElement fluentWait(By Locator){
//        Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
//                .withTimeout(Duration.ofSeconds(5))
//                .pollingEvery(Duration.ofMillis(500))
//                .ignoring(StaleElementReferenceException.class)
//                .ignoring(NoSuchElementException.class)
//                .ignoring(ElementNotInteractableException.class)
//                .ignoring(AssertionError.class)
//                .withMessage("Failed");
//        WebElement foo=wait.until(Element -> driver.findElement(Locator));
//        return foo;
//    }
    @Test
    public void searchForLink(){
        String searchInput="Cucumber IO";
        String expectedLink="https://www.linkedin.com";
        landingPage.searchForDoc(searchInput);
        wait.until(d->{
         String actualLink=searchResultPage.getLink();

         Assert.assertTrue(actualLink.contains(expectedLink));
            return true;
        });
        
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
