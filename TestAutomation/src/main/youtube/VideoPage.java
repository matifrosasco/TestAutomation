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

    // Métodos para interactuar con la página del video
    public void maximizeVideo() {
        // Espera a que el video inicie
        WebDriverWait waitVideoStart = new WebDriverWait(driver, 20);
        waitVideoStart.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".html5-video-container video")));

        // Ejecuta JavaScript para poner el video en pantalla completa
        ((JavascriptExecutor) driver).executeScript("document.querySelector('.ytp-fullscreen-button').click()");
    }

    public void configureVideoSettings() {
        // Espera a que el botón de configuración esté presente y haz clic en él
        WebDriverWait waitSettings = new WebDriverWait(driver, 10);
        WebElement settingsIcon = waitSettings.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ytp-settings-button")));
        settingsIcon.click();

        // Espera hasta que la opción de calidad esté presente y haz clic en ella
        WebDriverWait waitQuality = new WebDriverWait(driver, 10);
        WebElement qualityOption = waitQuality.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#ytp-id-18 > div > div > div:nth-child(4)")));
        qualityOption.click();

        // Espera a que aparezcan las opciones de calidad
        WebDriverWait waitQualityOptions = new WebDriverWait(driver, 10);
        waitQualityOptions.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ytp-id-18\"]/div/div/div[4]")));

        // Selecciona la calidad HD (1080p)
        WebElement hdOption = driver.findElement(By.xpath("//span[text()='1080p']"));
        hdOption.click();
    }

    public void disableAutoPlay() {
        // Espera hasta que el botón de reproducción automática esté presente
        WebDriverWait waitAutoPlay = new WebDriverWait(driver, 10);
        WebElement autoPlay = waitAutoPlay.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#movie_player > div.ytp-chrome-bottom > div.ytp-chrome-controls > div.ytp-right-controls > button:nth-child(2) > div")));
        autoPlay.click();
    }

    public void waitForVideoToEnd() {
        // Espera hasta que el tiempo actual de reproducción alcance la duración total del video
        WebDriverWait waitVideoEnd = new WebDriverWait(driver, 300); // 300 segundos (ajusta según la duración esperada del video)
        waitVideoEnd.until((WebDriver webDriver) -> {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
            Double currentTime = (Double) jsExecutor.executeScript("return document.querySelector('.html5-main-video').currentTime");
            Double duration = (Double) jsExecutor.executeScript("return document.querySelector('.html5-main-video').duration");
            return currentTime >= duration;
        });
    }
}