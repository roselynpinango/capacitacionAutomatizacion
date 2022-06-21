package Edit.EcoTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Clase7 {
	String url = "https://demo.guru99.com/test/table.html";
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
	public void leerValoresTabla() {
		System.out.println("Segunda Fila, Primera Columna: " +
						driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).getText());
		
		System.out.println("Cuarta Fila, Tercera Columna: " +
						driver.findElement(By.xpath("//tbody/tr[4]/td[3]")).getText());
	}
}
