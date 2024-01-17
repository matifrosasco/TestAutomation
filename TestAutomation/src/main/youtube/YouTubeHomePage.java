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

    // Methods to interact with the home page
    
    // Open the home page
    public void openHomePage(String url) {
        driver.get(url);
    }
    
    // Open side menú   
    public void selectMenuIcon() {
        // Espera hasta que el ícono de menu sea visible e interactuable
    	WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement menuIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[1]/yt-icon-button[2]")));
        menuIcon.click();
    }
        
    public void navigateToYouTubeKids() {
    	
        // Scroll down to make sure the link to YouTube Kids is visible
    	WebElement sideMenu = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[1]/yt-icon-button[2]"));
    	scrollDown(sideMenu);

        // Wait for the link to YouTube Kids to appear and click on it
        By youTubeKidsLinkSelector = By.linkText("YouTube Kids");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement youTubeKidsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(youTubeKidsLinkSelector));
        youTubeKidsLink.click();
    }
            
    public void searchVideo(String searchQuery) {
        WebElement searchBox = driver.findElement(By.name("search_query"));
        searchBox.sendKeys(searchQuery);
        searchBox.sendKeys(Keys.ENTER);

        // Wait until the search results load
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contents")));
    }

    public void selectFirstVideo() {
    	
        // Wait until the first video is visible
        WebDriverWait waitVideo = new WebDriverWait(driver, 10);
        WebElement firstVideoContainer = waitVideo.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='contents']//ytd-video-renderer[1]//a[@id='thumbnail']")));

        // Select the first video
        firstVideoContainer.click();
    }
    
    // Method to scroll down the page that accepts an element as parameter
    private void scrollDown(WebElement element) {
    	
        // You can adjust the amount of scrolling according to your needs
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        js.executeScript("window.scrollBy(0, 100)");
    }
}
