 package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ClaseBase;

public class HomePage extends ClaseBase {



	By locatorRun = By.xpath(
			"//body/ion-app[1]/ng-component[1]/div[1]/div[1]/div[1]/div[1]/ion-nav[1]/page-login[1]/ion-content[1]/div[2]/div[2]/div[1]/div[4]/form[1]/ion-item[2]/div[1]/div[1]/ion-input[1]/input[1]");
	By locatorPassword = By.xpath(
			"//body/ion-app[1]/ng-component[1]/div[1]/div[1]/div[1]/div[1]/ion-nav[1]/page-login[1]/ion-content[1]/div[2]/div[2]/div[1]/div[4]/form[1]/ion-item[3]/div[1]/div[1]/ion-input[1]/input[1]");
	By locatorBtnIr = By.xpath(
			"	//body/ion-app[1]/ng-component[1]/div[1]/div[1]/div[1]/div[1]/ion-nav[1]/page-login[1]/ion-content[1]/div[2]/div[2]/div[1]/div[4]/form[1]/ion-item[3]/div[1]/button[2]/ion-icon[1]");
	By locatorLinkRegistrate = By.xpath("//strong[contains(text(),'Regístrate')]");
	By locatorLinkEncuentranos = By.xpath(
			"//body/ion-app[1]/ng-component[1]/div[1]/div[1]/div[1]/div[1]/ion-nav[1]/page-login[1]/ion-content[1]/div[2]/div[2]/div[1]/div[6]/div[1]/a[1]");
	By locatorLinkOlvidasteTuClave = By.xpath(
			"//body/ion-app[1]/ng-component[1]/div[1]/div[1]/div[1]/div[1]/ion-nav[1]/page-login[1]/ion-content[1]/div[2]/div[2]/div[1]/div[6]/div[2]/a[1]");
	By locatorLinkContactanos = By.xpath(
			"//body/ion-app[1]/ng-component[1]/div[1]/div[1]/div[1]/div[1]/ion-nav[1]/page-login[1]/ion-content[1]/div[2]/div[2]/div[1]/div[6]/div[1]/a[1]");
	By locatorMsjUltimoAcceso = By.xpath(
			"//label[contains(text(),'Último acceso:')]");
	By locatorMsjErrorEnDatos = By.xpath("//body/ion-app[1]/ion-alert[1]/div[1]/div[1]");
	By locatorBtnAceptarVentanaError = By.xpath("//body/ion-app[1]/ion-alert[1]/div[1]/div[3]/button[1]");
	By locatorFrameError = By.xpath("//body/ion-app[1]/ion-alert[1]/div[1]/div[1]");
	/*By locator = By.xpath("");
	By locator = By.xpath("");*/
	
	
	// sobreescribir el constructor
		public HomePage(WebDriver driver) {
			super(driver);
		}

	// método para obtener el Run, clave y hacer clic en enviar
	public void irALoguearse(String run, String password) {
		agregarTexto(esperaExplicita(locatorRun), run);
		agregarTexto(esperaExplicita(locatorPassword), password);
		esperarXSegundos(3000);
		click(esperaExplicita(locatorBtnIr));
	}

	public void irALoguearseParcialRun(String run) {
		agregarTexto(esperaExplicita(locatorRun), run);
		esperarXSegundos(3000);
		click(esperaExplicita(locatorBtnIr));
	}
	
	public void irALoguearseParcialPass(String password) {
		agregarTexto(esperaExplicita(locatorPassword), password);
		esperarXSegundos(3000);
		click(esperaExplicita(locatorBtnIr));
	}
	//metodo para verificar que el login fue exitoso
	public String verificarLogin() {
		return obtenerTexto(esperaExplicita(locatorMsjUltimoAcceso));
	}
	
	public String verificarLoginNotOk() {
		//System.out.println((contarFrames()));
		//irAframe(contarFrames());
		//irAframe(2);
		//driver.switchTo().alert().accept();
		
		return obtenerTexto(esperaExplicita(locatorMsjErrorEnDatos));
		
	}
	public void despuesVerificarLoginNotOk() {
		esperarXSegundos(3000);
		//irAframe(2);
		//driver.switchTo().alert();
		click(esperaExplicita(locatorBtnAceptarVentanaError));
		
		
	}
	
	public void irAEncuentranos() {
		click(esperaExplicita(locatorLinkEncuentranos));
		esperarXSegundos(3000);
	}

	
	public void irAOlvidasteTuClave() {
		// esperarXSegundos(3000);
		click(esperaExplicita(locatorLinkOlvidasteTuClave));
	}

	public void irAContactanos() {
		// esperarXSegundos(3000);
		click(esperaExplicita(locatorLinkContactanos));
	}
	
	public void irARegistrate() {
		// esperarXSegundos(3000);
		click(esperaExplicita(locatorLinkRegistrate));
	}
}
