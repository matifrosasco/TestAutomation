package main.mercadoLibre;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercadoLibreTest_2 {
    
	private static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\src\\resources\\drivers\\chromedriver.exe";
	
    public static void main(String[] args) {
		
    	WebDriver driver=null;
    	
    	//Set the Chrome driver location
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		
        //Launch Chrome browser
        driver = new ChromeDriver();
        MercadoLibreHomePage test2=new MercadoLibreHomePage(driver);
        test2.openHomePage("https://www.mercadolibre.com.ar/#from=homecom");
        test2.maximizePage();
        test2.informationLogo();
        
        
        

	}

}
