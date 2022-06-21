package Edit.EcoTesting;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Clase2 {
	String url = "http://automationpractice.com/index.php";
	String chromeDriverPath = "..\\EcoTesting\\Drivers\\chromedriver.exe";
	String firefoxDriverPath = "..\\EcoTesting\\Drivers\\geckodriver.exe";
	
	@Test
	public void HacerBusquedaEnChrome() {
		// Paso 1: Indicar donde está el driver del navegador
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		// Paso 2: Abrir el navegador en la página a probar
		WebDriver navegador = new ChromeDriver();
		navegador.get(url);
		
		// Paso 3: Escribir la palabra/frase a buscar
		WebElement buscador = navegador.findElement(By.id("search_query_top"));
		buscador.sendKeys("dress");
		
		// Paso 4: Hacer la búsqueda
		buscador.sendKeys(Keys.ENTER); // Simular que presionamos la tecla ENTER
		
		// Paso 5: Cerrar el navegador
		navegador.close();
	}
	
	@Test
	public void HacerBusquedaEnFirefox() {
		// Paso 1: Indicar donde está el driver del navegador
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
		
		// Paso 2: Abrir el navegador en la página a probar
		WebDriver navegador = new FirefoxDriver();
		navegador.get(url);
		
		// Paso 3: Escribir la palabra/frase a buscar
		WebElement buscador = navegador.findElement(By.id("search_query_top"));
		buscador.sendKeys("dress");
		
		// Paso 4: Hacer la búsqueda
		buscador.sendKeys(Keys.ENTER); // Simular que presionamos la tecla ENTER
		
		// Paso 5: Cerrar el navegador
		navegador.close();
	}
}
