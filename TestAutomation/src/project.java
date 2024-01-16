import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class project {

	public static void main(String[] args) {
		System.setProperty("webdriver.Chrome",
				"C:\\Users\\Usuario\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Pasar la instancia de ChromeDriver al constructor de la clase page
		page test = new page(driver); 

		test.obtenerUrl(); // nos lleva a youtube
		test.maximzar();
		test.searchProduct("Mejores goles 2023"); // caja de busqueda
		// test.searchProdcut();}
		
		//otro comentario

	}
}

