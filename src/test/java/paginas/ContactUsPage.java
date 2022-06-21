package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {
	// Elementos
	@FindBy(id="id_contact")
	WebElement selSubject;
	
	@FindBy(css="#email")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='id_order']")
	WebElement txtOrder;
	
	@FindBy(name="fileUpload")
	WebElement filAttached;
	
	@FindBy(tagName="textarea")
	WebElement txtMessage;
	
	@FindBy(id="submitMessage")
	WebElement btnSend;
	
	// Constructor
	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones
	public void seleccionarSubject(String textoVisible) {
		Select subject = new Select(selSubject);
		subject.selectByVisibleText(textoVisible);
	}
	
	public void escribirEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirOrder(String order) {
		txtOrder.sendKeys(order);
	}
	
	public void escribirAttachedFile(String rutaArchivo) {
		filAttached.sendKeys(rutaArchivo);
	}
	
	public void escribirMessage(String mensaje) {
		txtMessage.sendKeys(mensaje);
	}
	
	public void hacerClicEnSend() {
		btnSend.click();
	}
	
	public void completarFormularioContactUs(String textoLista, String email, String order, String rutaArchivo, String mensaje) {
		Select lista = new Select(selSubject);
		lista.selectByVisibleText(textoLista);
		
		txtEmail.sendKeys(email);
		txtOrder.sendKeys(order);
		filAttached.sendKeys(rutaArchivo);
		txtMessage.sendKeys(mensaje);
		
		btnSend.click();
	}
}	
