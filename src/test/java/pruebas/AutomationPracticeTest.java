package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.ContactUsPage;
import paginas.HomePage;

public class AutomationPracticeTest {
	String url = "http://automationpractice.com";
	String driverPath = "..\\EcoTesting\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void buscarPalabra() {
		HomePage inicio = new HomePage(driver);
		
		inicio.escribirEnBuscador("dress");
		inicio.hacerClicEnBuscar();
	}
	
	@Test
	public void irAContactanos() {
		HomePage inicio = new HomePage(driver);
		
		inicio.hacerClicEnContactUs();
		
		ContactUsPage contacto = new ContactUsPage(driver);
		contacto.seleccionarSubject("Webmaster");
		contacto.escribirEmail("correo@micorreo.com");
		contacto.escribirOrder("3ca");
		contacto.escribirAttachedFile("C:\\addIntegerData.txt");
		contacto.escribirMessage("Mensaje del Contacto");
		contacto.hacerClicEnSend();
		
		/*
		 * contacto.completarFormularioContactUs("Webmaster", 
												"correo@micorreo.com", 
												"3ca", 
												"C:\\addIntegerData.txt", 
												"Mensaje del Contacto");
		*/	
	}
}
