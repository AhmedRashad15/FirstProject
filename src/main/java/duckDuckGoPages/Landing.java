package duckDuckGoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Landing extends PageBase{
    String pageLink= "https://duckduckgo.com/";
    By searchField= By.id("searchbox_input");


    public Landing(WebDriver driver){
        super(driver);
    }

    public void navigate(){
        driver.navigate().to(pageLink);
    }

    public void searchForDoc(String searchInput){
        driver.findElement(searchField).sendKeys(searchInput, Keys.ENTER);

    }

}
