package main.youtube;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YouTubeTest_2 {
    private static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\src\\resources\\drivers\\chromedriver.exe";


	public static void main(String[] args) {
		
		WebDriver driver = null;
		// Configura la ubicación del controlador de Chrome
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		 // Inicia el navegador Chrome
        driver = new ChromeDriver();
        
        YouTubeHomePage homePage = new YouTubeHomePage(driver);
    
        // Abre la página de YouTube
        homePage.openHomePage("https://www.youtube.com/");
		
	}

}
