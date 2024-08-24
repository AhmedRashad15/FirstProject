package testsPackage.linear;

import duckDuckGoPages.Landing;
import herokuappPages.LandingPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

public class Task6 {
    WebDriver driver;
    LandingPage landing;
    Wait<WebDriver> wait;
    String url="http://the-internet.herokuapp.com/checkboxes";

    @BeforeMethod
    public void setUp(){

        driver=new ChromeDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1080,720));
        wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(AssertionError.class);


        landing =new LandingPage(driver);
        landing.navigate(url);

    }
    @Test
    public void CheckIfCheckBoxSelected(){
        wait.until(d-> {
            landing.checkTheBox1();
            Assert.assertTrue(landing.isBoxesChecked());
        return true;
        });


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
