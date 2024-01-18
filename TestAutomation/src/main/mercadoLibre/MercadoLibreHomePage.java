package main.mercadoLibre;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.youtube.YouTubeHomePage;

public class MercadoLibreHomePage {


	private WebDriver driver;
	
	public MercadoLibreHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Methods to interact with the home page
    public void openHomePage(String url) {
        driver.get(url);
    }
    
    //screen mazimize
    public void maximizePage() {
    	driver.manage().window().maximize();
    }
    
    //enter empty mail
    public void enterEmail(String email) {
    	driver.findElement(By.xpath("//*[@id=\"nav-header-menu\"]/a[2]")).click(); //enter button
    	driver.findElement(By.name("user_id")).sendKeys(email); //empty email
    	driver.findElement(By.className("andes-button__content")).click(); //click to continue
        

    }
    public void enterPassword (String password) {
    	WebDriverWait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("andes-button__content")));
    	driver.findElement(By.className("andes-button__content")).click();
    	driver.findElement(By.name("password")).sendKeys(password);
    }
    
    //back to text
    public void text() {		
    	String texto= driver.findElement(By.className("ui-form__message")).getText();
		
		if(texto.equalsIgnoreCase("Completá este dato.")) {
			System.out.println("Test PASS");
		}else {
			System.out.println("Test FAIL");
		}
    }
    //returns a boolean value if the element has been displayed, along with its information.
    public void informationLogo() {
    	boolean logo=driver.findElement(By.className("nav-logo")).isDisplayed();
    	System.out.println(logo);
    	//regresa informacion de la imagen, ubicacion,tamaño
    	Rectangle imgml = driver.findElement(By.className("nav-logo")).getRect();
    	System.out.println("Coordenadas de ubicacion " + imgml.getX() + " y " + imgml.getY() + ". Tamaño de la imagen: " + imgml.getWidth() + " ancho por " + imgml.getHeight() + " de alto.");
    	
    }
}
