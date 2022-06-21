package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	// Elementos de la página web
	@FindBy(id="search_query_top") // id, name, partialLinkText, linkText, xpath, css
	WebElement txtBuscador;
	
	@FindBy(name="submit_search")
	WebElement btnBuscar;
	
	@FindBy(linkText="Contact us")
	WebElement lnkContactUs;
	
	// Constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones sobre los elementos de la página web
	public void escribirEnBuscador(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void hacerClicEnBuscar() {
		btnBuscar.click();
	}
	
	public void hacerClicEnContactUs() {
		lnkContactUs.click();
	}
}
