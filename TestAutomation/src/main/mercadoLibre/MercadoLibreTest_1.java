package main.mercadoLibre;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercadoLibreTest_1 { //
    private static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\src\\resources\\drivers\\chromedriver.exe";

	public static void main(String[] args) {
		WebDriver driver = null;
		
		//Set the Chrome driver location
		
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        
        //Launch Chrome browser
        driver = new ChromeDriver();
        
        MercadoLibreHomePage login= new MercadoLibreHomePage(driver);
        login.openHomePage("https://www.mercadolibre.com.ar/#from=homecom");
        login.maximizePage();
        login.enterEmail("");
        login.text();
	}
//TEST 1: when inserting an empty email, it has to return a message saying: "Completá este dato."
}
