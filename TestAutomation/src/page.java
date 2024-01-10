import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class page {

	WebDriver driver =new ChromeDriver();

	
	public void obtenerUrl() { //derivar a la pagina
		driver.get("https://www.youtube.com");
	}

	public void searchProdcut(String busqueda){ 
		driver.findElement(By.name("search_query")).sendKeys(busqueda); //caja de busqued
		
	}
}

//driver.manage().window().maximize();
