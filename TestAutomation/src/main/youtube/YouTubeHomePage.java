package main.youtube;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YouTubeHomePage {
    private WebDriver driver;

    // Constructor
    public YouTubeHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Métodos para interactuar con la página principal
    
    // Abrir la página principal
    public void openHomePage(String url) {
        driver.get(url);
    }
    
    // Abrir el menú lateral    
    public void selectMenuIcon() {
        // Espera hasta que el ícono de menu sea visible e interactuable
    	WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement menuIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[1]/yt-icon-button[2]")));
        menuIcon.click();
    }
    
    /*/ Desplázate hacia abajo para asegurarte de que el enlace a YouTube Kids sea visible
    scrollDown();
    
    // Espera a que aparezca el enlace a YouTubeKids y haz clic en él
    By youTubeKidsLinkSelector = By.linkText("YouTube Kids");
    WebElement youTubeKidsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(youTubeKidsLinkSelector));
    youTubeKidsLink.click(); */
    
    
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
    
    // Método para hacer scroll down en la página
    private void scrollDown() {
        // Puedes ajustar la cantidad de desplazamiento según tus necesidades
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
    }
}
