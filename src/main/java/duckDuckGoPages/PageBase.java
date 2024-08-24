package duckDuckGoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageBase {
    public WebDriver driver;
    public PageBase(WebDriver driver){
        this.driver=driver;
    }

    public void click(By Locator){
        driver.findElement(Locator).click();
    }


}
