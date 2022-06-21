package Edit.EcoTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DatosExcel;

public class Clase6b {
	String url = "http://automationpractice.com/";
	String driverPath = "..\\EcoTesting\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(dataProvider="Datos Login Excel")
	public void login(String email, String password) {
		// Paso 1 - Hacer clic en Sign In
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		
		// Paso 2 - Completar las credenciales
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.cssSelector("#passwd")).sendKeys(password);
		
		// Paso 3 - Hacer clic en el botón para iniciar sesión
		driver.findElement(By.name("SubmitLogin")).click();
		
		// Comprobar si el usuario se pudo loguear
		String tituloEsperado = "My account - My Store";
		Assert.assertEquals(driver.getTitle(), tituloEsperado);
		
		// Desloguear al usuario
		driver.findElement(By.linkText("Sign out")).click();
		
		/* Otra forma de hacerlo con el if (pero sin que falle cuando son datos negativos) 
		if (driver.getTitle().equalsIgnoreCase(tituloEsperado)) {
			driver.findElement(By.linkText("Sign out")).click();
		} 
		*/
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		return DatosExcel.leerExcel("..\\EcoTesting\\Datos\\DatosLogin.xlsx", "Hoja1");
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos() {
		/* 
		 * Devolver una matriz (filas y columnas) con los datos para la ejecución 
		 * - Filas: representan cada prueba que se va a hacer
		 * - Columnas: representan los parámetros de la prueba
		 */
		Object[][] datos = new Object[3][2]; // matriz tiene 3 filas y 2 columnas

		// Primera fila de datos
		datos[0][0] = "abc@correo.com";
		datos[0][1] = "1qe3q2e23r";

		datos[1][0] = "def@correo.com";
		datos[1][1] = "78i7yit";

		datos[2][0] = "ghi@correo.com";
		datos[2][1] = "sfcsawfea";
		
		return datos;
	}
}
