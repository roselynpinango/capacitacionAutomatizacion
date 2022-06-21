package Edit.EcoTesting;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Clase3 {
	String url = "http://automationpractice.com/";
	String driverPath = "..\\EcoTesting\\Drivers\\chromedriver.exe";
	
	@Test
	public void irAContactUs() {
		// Paso 1: Indicar donde está el driver
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito"); 
		
		/*
		 * incognito
		 * start-maximized
		 * headless
		 * */
		
		// Paso 2: Abrir el navegador en la página a probar
		WebDriver driver = new ChromeDriver(options);
		driver.navigate().to(url); // Es igual a driver.get(url);
		driver.manage().window().maximize(); // Maximiza la ventana
		driver.manage().deleteAllCookies(); // Borra las cookies
		
		// Paso 3: Hacer clic en el link Contact us
		driver.findElement(By.linkText("Contact us")).click();
		
		// Paso 4: Completar el formulario
		Select lista = new Select(driver.findElement(By.tagName("select")));
		lista.selectByVisibleText("Webmaster");
		
		driver.findElement(By.id("email")).sendKeys("correo1@mailinator.com");
		
		driver.findElement(By.xpath("//input[@id='id_order']")).sendKeys("1A");
		
		driver.findElement(By.name("fileUpload")).sendKeys("C:\\addIntegerData.txt");
		
		driver.findElement(By.cssSelector("#message")).sendKeys("Comentarios sobre el contacto");
		
		// Paso 5: Hacer clic en Send
		driver.findElement(By.xpath("//button[@id='submitMessage']")).click();
	}
}
