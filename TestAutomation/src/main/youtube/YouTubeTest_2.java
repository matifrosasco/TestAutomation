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
            // Configura la ubicación del controlador de Chrome
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

            // Inicia el navegador Chrome
            driver = new ChromeDriver();

            // Maximiza la ventana del navegador
            driver.manage().window().maximize();

            // Crear instancias de las páginas
            YouTubeHomePage homePage = new YouTubeHomePage(driver);
            KidsPage kidsPage = new KidsPage(driver);

            // Abre la página de YouTube
            homePage.openHomePage("https://www.youtube.com/");

            // Abre el menú lateral
            homePage.selectMenuIcon();
            
            // Busca el link hacia la página YouTube Kids y hace click 

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                // Cierra el navegador
                driver.quit();
            }
        }
    }
}