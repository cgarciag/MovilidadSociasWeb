package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ClaseBase;

public class Registrate extends ClaseBase{
	
	By locatorBtnRun = By.xpath("//body/ion-app[1]/ng-component[1]/div[1]/div[1]/div[1]/div[1]/ion-nav[1]/page-registerclient[1]/ion-content[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[2]/ion-list[1]/ion-item[1]/div[1]/ion-radio[1]/button[1]/span[1]");
	By locatorTxtRun = By.xpath("//body/ion-app[1]/ng-component[1]/div[1]/div[1]/div[1]/div[1]/ion-nav[1]/page-registerclient[1]/ion-content[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[2]/input-button[1]/div[1]/ion-item[1]/div[1]/div[1]/ion-input[1]/input[1]");
	By locatorBtnNext = By.xpath("//body/ion-app[1]/ng-component[1]/div[1]/div[1]/div[1]/div[1]/ion-nav[1]/page-registerclient[1]/ion-content[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[2]/input-button[1]/div[1]/ion-item[1]/div[1]/button[1]/ion-icon[1]");
	By locatorBtnSiEsMiNumero = By.xpath("//body/ion-app[1]/ng-component[1]/div[1]/div[1]/div[1]/div[1]/ion-nav[1]/page-registerclient[1]/ion-content[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[3]/ion-list[1]/ion-item[1]/div[1]/ion-radio[1]/button[1]/span[1]");
	By locatorBtnNoEsMiNumero = By.xpath("//body/ion-app[1]/ng-component[1]/div[1]/div[1]/div[1]/div[1]/ion-nav[1]/page-registerclient[1]/ion-content[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[3]/ion-list[1]/ion-item[2]/div[1]/ion-radio[1]/button[1]/span[1]");
	By locatorTxtCodigo = By.xpath("//body/ion-app[1]/ng-component[1]/div[1]/div[1]/div[1]/div[1]/ion-nav[1]/page-registerclient[1]/ion-content[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[4]/div[2]/input-button[1]/div[1]/ion-item[1]/div[1]/div[1]/ion-input[1]/input[1]");
	By locatorTxtRegistro = By.xpath("//label[contains(text(),'Registro')]");
	By locatorTxtRegistro2 = By.xpath("//div[contains(text(),'Perfecto, te enviamos un mensaje de texto con un c')]");
	
	/*By locator = By.xpath("");
	By locator = By.xpath("");
	By locator = By.xpath("");
	By locator = By.xpath("");*/
	

	public Registrate(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	/*public void irARun() {
		click(esperaExplicita(locatorBtnRun));
		esperarXSegundos(3000);
	}*/
	
	public void irARun(String run) {
		// esperarXSegundos(3000);
		click(esperaExplicita(locatorBtnRun));
		agregarTexto(esperaExplicita(locatorTxtRun), run);
		click(esperaExplicita(locatorBtnNext));
		esperarXSegundos(2000);
		click(esperaExplicita(locatorBtnSiEsMiNumero));	
	}
	
	public String verificarRegistro() {
		return obtenerTexto(esperaExplicita(locatorTxtRegistro));
	}
	
	public String verificarRegistro2() {
		return obtenerTexto(esperaExplicita(locatorTxtRegistro2));
	}
	/*public void irALoguearse(String run, String password) {
		agregarTexto(esperaExplicita(locatorRun), run);
		agregarTexto(esperaExplicita(locatorPassword), password);
		esperarXSegundos(3000);
		click(esperaExplicita(locatorBtnIr));
	} */

}
