import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class page {

	WebDriver driver =new ChromeDriver();

	
	public void obtenerUrl() { //derivar a la pagina
		driver.get("\"https://www.mercadolibre.com.ar/#from=homecom\"");
	}

	public void searchProdcut(){ 
		WebElement searchProduct = driver.findElement(By.id("cb1-edit")); //caja de busqueda
		
	}
}
//driver.manage().window().maximize();