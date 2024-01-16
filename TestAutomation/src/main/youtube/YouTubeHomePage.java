package main.youtube;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YouTubeHomePage {
    private WebDriver driver;

    // Constructor
    public YouTubeHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Métodos para interactuar con la página principal
    public void openHomePage(String url) {
        driver.get(url);
    }

    public void searchVideo(String searchQuery) {
        WebElement searchBox = driver.findElement(By.name("search_query"));
        searchBox.sendKeys(searchQuery);
        searchBox.sendKeys(Keys.ENTER);

        // Espera hasta que los resultados de búsqueda se carguen
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contents")));
    }

    public void selectFirstVideo() {
        // Espera hasta que el primer video sea visible
        WebDriverWait waitVideo = new WebDriverWait(driver, 10);
        WebElement firstVideoContainer = waitVideo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='contents']//ytd-video-renderer[1]//a[@id='thumbnail']")));

        // Selecciona el primer video
        firstVideoContainer.click();
    }
}
