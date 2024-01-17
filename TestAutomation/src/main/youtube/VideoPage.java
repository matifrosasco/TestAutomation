package main.youtube;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VideoPage {
    private WebDriver driver;

    // Constructor
    public VideoPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with the video page
    
    public void maximizeVideo() {
        // Wait for the video to start
        WebDriverWait waitVideoStart = new WebDriverWait(driver, 20);
        waitVideoStart.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".html5-video-container video")));

        // Run JavaScript to make the video full screen
        ((JavascriptExecutor) driver).executeScript("document.querySelector('.ytp-fullscreen-button').click()");
    }

    public void configureVideoSettings() {
        // Wait for the settings button to be present and click on it
        WebDriverWait waitSettings = new WebDriverWait(driver, 10);
        WebElement settingsIcon = waitSettings.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ytp-settings-button")));
        settingsIcon.click();

        // Wait until the quality option is present and click on it
        WebDriverWait waitQuality = new WebDriverWait(driver, 10);
        WebElement qualityOption = waitQuality.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#ytp-id-18 > div > div > div:nth-child(4)")));
        qualityOption.click();

        // Wait for the quality options to appear
        WebDriverWait waitQualityOptions = new WebDriverWait(driver, 10);
        waitQualityOptions.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ytp-id-18\"]/div/div/div[4]")));

        // Select HD quality (1080p)
        WebElement hdOption = driver.findElement(By.xpath("//span[text()='1080p']"));
        hdOption.click();
    }

    public void disableAutoPlay() {
    	
        // Wait until the autoplay button is present
        WebDriverWait waitAutoPlay = new WebDriverWait(driver, 10);
        WebElement autoPlay = waitAutoPlay.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#movie_player > div.ytp-chrome-bottom > div.ytp-chrome-controls > div.ytp-right-controls > button:nth-child(2) > div")));
        autoPlay.click();
    }

    public void waitForVideoToEnd() {
    	
        // Wait until the current playback time reaches the total length of the video
        WebDriverWait waitVideoEnd = new WebDriverWait(driver, 300); // 300 segundos (ajusta según la duración esperada del video)
        waitVideoEnd.until((WebDriver webDriver) -> {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
            Double currentTime = (Double) jsExecutor.executeScript("return document.querySelector('.html5-main-video').currentTime");
            Double duration = (Double) jsExecutor.executeScript("return document.querySelector('.html5-main-video').duration");
            return currentTime >= duration;
        });
    }
}