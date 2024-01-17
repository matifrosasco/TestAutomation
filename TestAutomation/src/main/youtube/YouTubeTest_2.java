package main.youtube;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YouTubeTest_2 {
	
	private static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\src\\resources\\drivers\\chromedriver.exe";
	
	public static void main(String[] args) {
		
     	WebDriver driver = null;

        try {
            // Set the location of the Chrome driver
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

            // Start the Chrome browser
            driver = new ChromeDriver();

            // Maximize the browser window
            driver.manage().window().maximize();

            // Create page instances
            YouTubeHomePage homePage = new YouTubeHomePage(driver);
            KidsPage kidsPage = new KidsPage(driver);

            // Open the YouTube page
            homePage.openHomePage("https://www.youtube.com/");
                    
            // Look for the link to the YouTube Kids page and click
            homePage.navigateToYouTubeKids();
                                  
            // Select the button "Soy Un Niño"
            kidsPage.selectSoyUnNino();
            
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                // Close the browser
                driver.quit();
            }
        }
    }
}