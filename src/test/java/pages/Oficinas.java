package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ClaseBase;

public class Oficinas extends ClaseBase{

	By locatorMsjNuestrasOficinas = By.xpath("/html/body/div[1]/div/section[1]/div/div[1]/div/div/div/div/div/div[1]/div/div/div[3]/div/div/div/div/div/div/div/div[2]/div/h3/a");
	
	public Oficinas(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String verificarEncuentranos() {
		esperarXSegundos(3000);
		return obtenerTexto(esperaExplicita(locatorMsjNuestrasOficinas));
	}
}
