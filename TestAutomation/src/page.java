import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class page {

	WebDriver driver;

    // Constructor que recibe un WebDriver (ChromeDriver)
    public page(WebDriver driver) {
        this.driver = driver;
    }

	//derivar a la pagina
	public void obtenerUrl() { 
		driver.get("https://www.youtube.com");
	}
	//maximizar la pagina
	public void maximzar() {
		driver.manage().window().maximize(); 
	}
	//caja de busqueda
	public void searchProduct(String busqueda){ 
		driver.findElement(By.name("search_query")).sendKeys(busqueda); 
		
	}
	
}

