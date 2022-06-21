package Edit.EcoTesting;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilities.CapturaEvidencia;

public class Clase6 {
	String url = "http://automationpractice.com/";
	String driverPath = "..\\EcoTesting\\Drivers\\chromedriver.exe";
	String dirEvidencias = "..\\EcoTesting\\Evidencias\\"; 
	String nombreDocumento = "Evidencias - AutomationPractice 14Jun2022.docx";
	WebDriver driver;
	File pantalla;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void login() throws IOException {
		// Captura de Evidencia (Formato Imagen)
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(dirEvidencias + "01_pantalla_principal.jpg"));
		
		// Paso 1 - Hacer clic en Sign In
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(dirEvidencias + "02_fomulario_login.jpg"));
		
		// Paso 2 - Completar las credenciales
		driver.findElement(By.id("email")).sendKeys("correo@micorreo.com");
		driver.findElement(By.cssSelector("#passwd")).sendKeys("1q2w3e4r5t");
		
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(dirEvidencias + "03_credenciales_completas.jpg"));
		
		// Paso 3 - Hacer clic en el botón para iniciar sesión
		driver.findElement(By.name("SubmitLogin")).click();
		
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(dirEvidencias + "04_resultado_obtenido.jpg"));
	}
	
	@Test
	public void loginConDocumento() throws InvalidFormatException, IOException, InterruptedException {
		CapturaEvidencia.escribirTituloEnDocumento(dirEvidencias + nombreDocumento, "Documento de Evidencias de Prueba", 20);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Pantalla Principal");
		
		// Paso 1 - Hacer clic en Sign In
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Luego de hacer clic en Sign In");
		
		// Paso 2 - Completar las credenciales
		driver.findElement(By.id("email")).sendKeys("correo@mailinator.com");
		driver.findElement(By.cssSelector("#passwd")).sendKeys("Q1W2E3R4T5Y6");
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Luego de ingresar las credenciales");

		// Paso 3 - Hacer clic en el botón para iniciar sesión
		driver.findElement(By.name("SubmitLogin")).click();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Luego de hacer clic en el botón para iniciar sesión");
		
		try {
			// Comprobar que se pudo iniciar sesión
			Assert.assertEquals(driver.getTitle(), "My account - My Store");
		} catch (AssertionError e) {
			CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + "Falla.docx", "Error luego de hacer clic en el botón para iniciar sesión");
		}
	}
}
