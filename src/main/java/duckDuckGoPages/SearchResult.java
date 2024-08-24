package duckDuckGoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResult extends PageBase{
By resultLink=By.xpath("(//article)[1]//h2/a");
By getTitle=By.xpath("(//article)[4]//h2//span");
public SearchResult(WebDriver driver){
    super(driver);
}

public String getLink(){
    return driver.findElement(resultLink).getAttribute("href");
}

public String getTitle(){
    return driver.findElement(getTitle).getText();
}



}
