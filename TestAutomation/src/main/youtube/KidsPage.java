package main.youtube;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KidsPage {
    private WebDriver driver;

    // Constructor
    public KidsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with YouTube Kids page
    
    // Select the option "Soy Un Niño"
    public void selectSoyUnNino() {
    	// Wait until the "Soy Un Niño" is visible
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement soyUnNinoButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='kid-button']")));

        // Select the first video
        soyUnNinoButton.click();
    }
    
    
}