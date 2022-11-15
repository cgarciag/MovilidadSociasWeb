package listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener  {
	
	String filePath = "C:\\Users\\cgarciag\\eclipse-workspace\\Movilidad_WebSociasNVO\\test-output\\printScreen\\";

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// Método para tomar evidencia en test exitosos
		
		System.out.println("*** Caso de Prueba -" + result.getName() + "- exitoso ***");
		String nombreMetodo = result.getName().toString().trim();
		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver)context.getAttribute("WebDriver");
		takeScreenShot(nombreMetodo, driver);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// Método en caso que fallen los test
		System.out.println("*** ERROR Caso de Prueba -" + result.getName() + "- ha fallado ***");
		String nombreMetodo = result.getName().toString().trim();
		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver)context.getAttribute("WebDriver");
		takeScreenShot(nombreMetodo, driver);
	}
	
	public void takeScreenShot(String methodName, WebDriver driver ) {
		Calendar calendario = Calendar.getInstance();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		String imprimirFecha = formatoFecha.format(calendario.getTime());
		File sourceFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Con este metodo se guarda el archivo
		try {
			FileHandler.copy(sourceFile, new File(filePath+methodName+"-"+imprimirFecha+".png"));
			System.out.println("*** Se guardó una captura de pantalla en la carpeta: "+ filePath + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	public void onFinish(ITestResult result) {
		// Método para tomar evidencia al finalizar
				System.out.println("*** PASSED " + result.getName() + " ha pasado ***");
				String nombreMetodo = result.getName().toString().trim();
				ITestContext context = result.getTestContext();
				WebDriver driver = (WebDriver)context.getAttribute("WebDriver");
				takeScreenShot(nombreMetodo, driver);
	}*/

}
