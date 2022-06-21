package Edit.EcoTesting;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilities.CapturaEvidencia;


public class Clase5 {
	String url = "http://automationpractice.com";
	String driverPath = "..\\EcoTesting\\Drivers\\chromedriver.exe";
	WebDriver driver;
	File pantalla;
	String dirEvidencias = "..\\EcoTesting\\Evidencias\\";
	String nombreDocumento = "Evidencias.docx";
	
	@BeforeSuite
	public void abrirPagina() {   // setUp
		// Todas las instrucciones que son comunes a ambos @Test al inicio 
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(description="CP Ir a Contáctanos", priority=1)
	public void irContactUs() throws InvalidFormatException, IOException, InterruptedException {
		// configurando el documento de evidencias
		CapturaEvidencia.escribirTituloEnDocumento(dirEvidencias + nombreDocumento, "Documento de Evidencias de Prueba", 18);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Pantalla Principal");
		
		// Paso 3: Hacer clic en el link Contact us
		driver.findElement(By.linkText("Contact us")).click();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Paso 1 - Luego de hacer clic en Contact Us");
				
		// Paso 4: Completar el formulario
		Select lista = new Select(driver.findElement(By.tagName("select")));
		lista.selectByVisibleText("Webmaster");
				
		driver.findElement(By.id("email")).sendKeys("correo1@mailinator.com");
			
		driver.findElement(By.xpath("//input[@id='id_order']")).sendKeys("1A");
				
		driver.findElement(By.name("fileUpload")).sendKeys("C:\\addIntegerData.txt");
				
		driver.findElement(By.cssSelector("#message")).sendKeys("Comentarios sobre el contacto");
				
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Paso 2 - Luego de completar el formulario");
		
		// Paso 5: Hacer clic en Send
		driver.findElement(By.xpath("//button[@id='submitMessage']")).click();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Paso 3 - Luego de enviar el mensaje de contacto");
	}
	
	@Test(description="CP Buscar Palabra", priority=5)
	public void buscarPalabra() throws IOException {
		// Captura de Pantalla
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(dirEvidencias + "01_pantalla_principal.jpg"));
		
		// Paso 3: Escribir la palabra/frase a buscar
		WebElement buscador = driver.findElement(By.id("search_query_top"));
		buscador.sendKeys("dress");
		
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(dirEvidencias + "02_palabra_a_buscar.jpg"));
				
		// Paso 4: Hacer la búsqueda
		buscador.sendKeys(Keys.ENTER); // Simular que presionamos la tecla ENTER
		
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(dirEvidencias + "03_resultado_busqueda.jpg"));
		
		// Comprobaciones para verificar que la busqueda se realizó
		// >>> La URL cambió, el título cambió
		String urlEsperada = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
		String tituloEsperado = "Search - My Store";
		
		String urlActual = driver.getCurrentUrl(); // Devuelve la URL actual de la pagina
		String tituloActual = driver.getTitle(); // Devuelve el titulo actual de la pagina
		
		Assert.assertEquals(urlActual, urlEsperada);
		Assert.assertEquals(tituloActual, tituloEsperado);
	}
	
	@AfterSuite
	public void cerrarPagina() {   // tearDown
		driver.close();
	}
}
