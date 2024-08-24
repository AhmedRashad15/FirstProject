package herokuappPages;

import duckDuckGoPages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends PageBase{
    By firstCheckBox= By.xpath("//form/input[1]");
    By secondCheckBox=By.xpath("//form/input[2]");

    Boolean isChecked=false;
    public LandingPage(WebDriver driver){
        super(driver);
    }
    public void checkTheBox1(){
        driver.findElement(firstCheckBox).click();
    }
    public boolean isBoxesChecked()
    {
        if(driver.findElement(firstCheckBox).isSelected()
                &&driver.findElement(secondCheckBox).isSelected())
            isChecked=true;
        return isChecked;

    }
    public void navigate(String link){
        driver.navigate().to(link);
    }

}
