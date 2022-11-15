package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ClaseBase;

public class Inicio extends ClaseBase {

	By locatorLinkInicio = By.xpath("//body[1]/ion-app[1]/ng-component[1]/div[1]/div[1]/div[2]/div[1]/web-sidebar[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/label[1]");
	By locatorLinkIrAPagar = By.xpath("//body[1]/ion-app[1]/ng-component[1]/div[1]/div[1]/div[2]/div[1]/web-sidebar[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/label[1]");
	By locatorLinkCapacitacion = By.xpath("//body[1]/ion-app[1]/ng-component[1]/div[1]/div[1]/div[2]/div[1]/web-sidebar[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/label[1]");
	By locatorLinkDocumentos = By.xpath("//body[1]/ion-app[1]/ng-component[1]/div[1]/div[1]/div[2]/div[1]/web-sidebar[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[2]/label[1]");
	By locatorLinkBeneficios = By.xpath("//body[1]/ion-app[1]/ng-component[1]/div[1]/div[1]/div[2]/div[1]/web-sidebar[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[2]/label[1]");
	By locatorLinkVerPagos = By.xpath("//body[1]/ion-app[1]/ng-component[1]/div[1]/div[1]/div[2]/div[1]/web-sidebar[1]/div[1]/div[1]/div[2]/div[6]/div[1]/div[2]/label[1]");
	By locatorLinkEncuentranos = By.xpath("//label[contains(text(),'Encuéntranos')]");
	By locatorLinkOficinas = By.xpath("//label[contains(text(),'Oficinas')]");
	By locatorLinkContactanos = By.xpath("//label[contains(text(),'Contáctanos')]");
	By locatorLinkCentroDeAyuda = By.xpath("//label[contains(text(),'Centro de ayuda')]");
	By locatorLinkLinea800 = By.xpath("//label[contains(text(),'Línea 800')]");
	//By locator = By.xpath("");

	
	public Inicio(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
