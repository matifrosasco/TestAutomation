package main.mercadoLibre;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.youtube.YouTubeHomePage;

public class MercadoLibreHomePage {


	private WebDriver driver;
	
	public MercadoLibreHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Métodos para interactuar con la página principal
    public void openHomePage(String url) {
        driver.get(url);
    }
    
    //mazimizar pantalla
    public void maximizePage() {
    	driver.manage().window().maximize();
    }
    
    //enter email vacio
    public void enterEmail(String email) {
    	driver.findElement(By.xpath("//*[@id=\"nav-header-menu\"]/a[2]")).click(); //boton ingresar
    	driver.findElement(By.name("user_id")).sendKeys(email); //mail vacio
    	driver.findElement(By.className("andes-button__content")).click(); //click en continuar
        

    }
    public void enterPassword (String password) {
    	WebDriverWait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("andes-button__content")));
    	driver.findElement(By.className("andes-button__content")).click();
    	driver.findElement(By.name("password")).sendKeys(password);
    }
    
    //regresa el texto 
    public void text() {		
    	String texto= driver.findElement(By.className("ui-form__message")).getText();
		
		
		if(texto.equalsIgnoreCase("Completá este dato.")) {
			System.out.println("Test PASS");
		}else {
			System.out.println("Test FAIL");
		}
    }
    
    
   	
}
