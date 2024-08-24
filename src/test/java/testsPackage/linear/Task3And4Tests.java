package testsPackage.linear;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import duckDuckGoPages.Landing;
import duckDuckGoPages.SearchResult;

import java.time.Duration;

public class Task3And4Tests {
    WebDriver driver;
    Landing landingPage;
    SearchResult searchResultPage;

    String searchInput="Selenium WebDriver";
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
        driver=new ChromeDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1280 ,720));
        landingPage=new Landing(driver);
        searchResultPage=new SearchResult(driver);
        landingPage.navigate();
    }
    //Test Comment
    @Test
    public void task3(){

        landingPage.searchForDoc(searchInput);
        SearchResult searchResultPage=new SearchResult(driver);

        wait.until(d -> {
            Assert.assertEquals(searchResultPage.getLink()
, "https://www.selenium.dev/documentation/webdriver/");
            return true;
        });


    }
    @Test
    public void task4(){
        String searchInput="TestNg";
        landingPage.searchForDoc(searchInput);
        String actual="TestNG Tutorial";
        wait.until( d-> {

            SoftAssert softAssert = new SoftAssert();

            softAssert.assertEquals(searchResultPage.getTitle() , actual, "Assertion Failed");
            softAssert.assertAll();
            return true;
        });
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
