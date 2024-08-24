package herokuappPages;

import duckDuckGoPages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class UploadPage extends PageBase {
    public UploadPage(WebDriver driver){
        super(driver);
    }
    By chooseFileButton= By.id("file-upload");
    By uploadButton = By.id("file-submit");
    By successMessage=By.xpath("//div[@class='example']//h3");


    public void uploadFile(File path){
        driver.findElement(chooseFileButton).sendKeys(path.getPath());
        driver.findElement(uploadButton).click();

    }
    public String getSuccessMessage(){
       return driver.findElement(successMessage).getText();

    }


}
