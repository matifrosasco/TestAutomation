package youtube;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YouTubeTest_1 {

    private static final String CHROME_DRIVER_PATH = "D:/DATOS DE USUARIO/Documents/Tincho/Java-eclipse/selenium-cleartrip/src/drivers/chromedriver.exe";

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
            VideoPage videoPage = new VideoPage(driver);

            // Abre la página de YouTube
            homePage.openHomePage("https://www.youtube.com/");

            // Realiza la búsqueda y selecciona el primer video
            homePage.searchVideo("Penales Argentina vs Francia");
            homePage.selectFirstVideo();

            // Interactúa con la página del video
            videoPage.maximizeVideo();
            videoPage.configureVideoSettings();
            videoPage.disableAutoPlay();
            videoPage.waitForVideoToEnd();

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