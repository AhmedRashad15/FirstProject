package testsPackage.linear;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class ExtraTasks {
     WebDriver driver;

//    @BeforeClass
//    @Parameters("BrowserType")
//    public void setUp(String browserType){
//        if(browserType.equalsIgnoreCase("Chrome")){
//            dirver=new ChromeDriver();
//        }else if(browserType.equalsIgnoreCase("Firefox")){
//            dirver=new FirefoxDriver();
//        }
//
//
//    }
        public void setUp(String browserType){
        if(browserType.equalsIgnoreCase("Chrome")){
            driver=new ChromeDriver();
        }else if(browserType.equalsIgnoreCase("Firefox")){
            driver=new FirefoxDriver();
        }


    }


    public void tearDown(){
        driver.quit();
    }


    @Test
    public void assertGoogle(){
            setUp("Chrome");
        driver.get("https://www.google.com/ncr");
        Assert.assertEquals(driver.getTitle(),"Google");
        tearDown();
    }
    @Test
    public void assertOnLogo(){
    setUp("Chrome");
    driver.get("https://www.google.com/ncr");
    Assert.assertTrue(driver.findElement(By.className("lnXdpd")).isDisplayed());
    tearDown();
    }

    @Test()
    public void assertOnGoogleResultSearch() throws InterruptedException {
        setUp("Chrome");
         driver.get("https://www.google.com/ncr");
         WebElement googleSearchField= driver.findElement(By.id("APjFqb"));
         googleSearchField.sendKeys("Selenium WebDriver");
         googleSearchField.sendKeys(Keys.ENTER);
         Thread.sleep(3000);
         WebElement googleSearchResult=driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
         Assert.assertEquals("WebDriver - Selenium",googleSearchResult.getText(),"Wrong assertion");
        System.out.println("Success");
         tearDown();
    }

//    public WebElement fluentWait(final By locator) {
//        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//                .withTimeout(Duration.ofSeconds(5))
//                .pollingEvery(Duration.ofMillis(300))
//                .ignoring(NoSuchElementException.class)
//                .ignoring(StaleElementReferenceException.class)
//                .ignoring(ElementNotInteractableException.class)
//                .ignoring(AssertionError.class);
//
//        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver driver) {
//                return driver.findElement(locator);
//            }
//        });
//
//        return  foo;
//    };
//

    public WebElement fluentWait(final By Locator){
            Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(3))
                    .pollingEvery(Duration.ofMillis(300))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(ElementNotInteractableException.class)
                    .ignoring(StaleElementReferenceException.class);
            WebElement foo=wait.until(webDriver -> driver.findElement(Locator));
        return foo;
        }
    @Test
    public void openMozillaFireFox() throws InterruptedException {
        setUp("Firefox");
        driver.get("https://duckduckgo.com/");
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1080,1920));

//        Wait<WebDriver> wait =
//                new FluentWait<>(driver)
//                        .withTimeout(Duration.ofSeconds(7))
//                        .pollingEvery(Duration.ofMillis(300))
//                        .ignoring(ElementNotInteractableException.class)
//                        .ignoring(StaleElementReferenceException.class)
//                        .ignoring(NoSuchElementException.class)
//                        .ignoring(AssertionError.class);
              By searchField= By.id("searchbox_input");

//            wait.until(d ->{
//
//                By searchField= By.id("searchbox_input");
//                driver.findElement(searchField).sendKeys("TestNG");;
//                driver.findElement(searchField).sendKeys(Keys.ENTER);
//                return true;
//                }
//
//        );
        fluentWait(searchField);
        driver.findElement(searchField).sendKeys("TestNG");
        driver.findElement(searchField).sendKeys(Keys.ENTER);




        SoftAssert softAssert=new SoftAssert();
        By titleTestNG= By.xpath("(//article)[4]//h2//span");
        fluentWait(titleTestNG);
        String actual=driver.findElement(titleTestNG).getText();
        softAssert.assertEquals("TestNG Tutorial",actual,"Assertion Failed");
        softAssert.assertAll();
        driver.quit();

//        wait.until(d->{
//            By titleTestNG= By.xpath("(//article)[4]//h2//span");
//            String actual=driver.findElement(titleTestNG).getText();
//            softAssert.assertEquals("TestNG Tutorial",actual,"Assertion Failed");
//            softAssert.assertAll();
//         return true;
//        });


    }
}


