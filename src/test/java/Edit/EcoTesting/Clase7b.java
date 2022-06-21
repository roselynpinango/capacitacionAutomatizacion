package Edit.EcoTesting;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Clase7b {
	String url = "https://demoqa.com/alerts";
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
	public void alerta1() {
		driver.findElement(By.id("alertButton")).click();
		
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void alerta2() {
		driver.findElement(By.id("timerAlertButton")).click();
		
		// Esperar 10 segundos o hasta que aparezca una alerta
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void alerta3() {
		driver.findElement(By.id("confirmButton")).click();
		
		driver.switchTo().alert().dismiss();
	}
	
	@Test
	public void alerta4() {
		driver.findElement(By.id("promtButton")).click();
		
		Alert alerta = driver.switchTo().alert();
		alerta.sendKeys("Clase de Automatización");
		alerta.accept();
	
	}
}
