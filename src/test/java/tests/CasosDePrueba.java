package tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import pages.Inicio;
import pages.Oficinas;
import pages.Registrate;
import pages.HomePage;
import utils.DataDriven;
import utils.PropertiesDriven;
import org.openqa.selenium.JavascriptExecutor;

public class CasosDePrueba {
	//Atributos
	private WebDriver driver;
	private HomePage homePage;
	private Oficinas oficinaPage;
	private Registrate registratePage;
	private String urlSitio;
	private ArrayList<String> datosCP;
	ATUTestRecorder grabaVideo;

		@BeforeSuite
	//	@BeforeTest
		public void preparacion(ITestContext context) throws ATUTestRecorderException {
	
			String rutaDriver = PropertiesDriven.obtenerProperty("rutaDriver");
			//String rutaDriver = System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\chromedriver.exe";
			String browser = PropertiesDriven.obtenerProperty("browser");
			//String browser = "Chrome";
			//String propertyDriver = PropertiesDriven.obtenerProperty("propertyDriver");
			String propertyDriver = "webdriver.chrome.driver";
			homePage = new HomePage(driver);
			homePage.conexionDriver(browser, rutaDriver, propertyDriver);
			oficinaPage = new Oficinas(homePage.getDriver());
			registratePage = new Registrate(homePage.getDriver());
			urlSitio = PropertiesDriven.obtenerProperty("url");
			//urlSitio = "http://automationpractice.com/index.php"; 
			context.setAttribute("WebDriver",homePage.getDriver());
			datosCP = new ArrayList<>();
			grabaVideo = new ATUTestRecorder("C:\\Users\\cgarciag\\eclipse-workspace\\Movilidad_WebSociasNVO\\test-output\\printScreen\\videos\\", "Evidencia", false);
			grabaVideo.start();
		}
		
	/*	@BeforeTest
		public void preparacion2(ITestContext context) {
			String rutaDriver = PropertiesDriven.obtenerProperty("rutaDriver");
			//String rutaDriver = System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\chromedriver.exe";
			String browser = PropertiesDriven.obtenerProperty("browser");
			//String browser = "Chrome";
			//String propertyDriver = PropertiesDriven.obtenerProperty("propertyDriver");
			String propertyDriver = "webdriver.chrome.driver";
			homePage = new HomePage(driver);
			homePage.conexionDriver(browser, rutaDriver, propertyDriver);
			oficinaPage = new Oficinas(homePage.getDriver());
			registratePage = new Registrate(homePage.getDriver());
			urlSitio = PropertiesDriven.obtenerProperty("url");
			//urlSitio = "http://automationpractice.com/index.php"; 
			context.setAttribute("WebDriver",homePage.getDriver());
			datosCP = new ArrayList<>();
		}*/
		
		@BeforeMethod
		public void preparacionTests() {
			homePage.cargarURL(urlSitio);
			homePage.maximizarBrowser();
			
		}
		
		@AfterMethod
		public void posTests()  {
			driver = homePage.getDriver();
			
			//driver.quit();
			
		}
		@AfterSuite
		public void postSuite() throws ATUTestRecorderException {
			grabaVideo.stop();
		}
		
		//HOMEPAGE
		@Test
		public void CP001_LoginOk() {
			//Hacer Login (si aparece el captcha se cae) 
			//Ok al 7-11-22
			datosCP = DataDriven.getData("CP001_LoginOk");
			homePage.irALoguearse(datosCP.get(1), datosCP.get(2));
			Assert.assertEquals(homePage.verificarLogin(), datosCP.get(3));
			
		}
		
		@Test
		public void CP002_LoginClaveVacia() {
			//Hacer Login (si aparece el captcha se cae)
			//Ok al 7-11-22
			datosCP = DataDriven.getData("CP002_LoginClaveVacia");
			homePage.irALoguearseParcialRun(datosCP.get(1));
			Assert.assertEquals(homePage.verificarLoginNotOk(), datosCP.get(2));
			homePage.despuesVerificarLoginNotOk();
		}
		
		@Test
		public void CP003_LoginUsuarioVacio() {
			//Hacer Login (si aparece el captcha se cae)
			//Ok al 7-11-22
			datosCP = DataDriven.getData("CP003_LoginUsuarioVacio");
			homePage.irALoguearseParcialPass(datosCP.get(1));
			Assert.assertEquals(homePage.verificarLoginNotOk(), datosCP.get(2));
			homePage.despuesVerificarLoginNotOk();
		}
		
		@Test
		public void CP004_LoginUsuarioInvalido() {
			//Hacer Login (si aparece el captcha se cae)
			//Ok al 7-11-22
			datosCP = DataDriven.getData("CP004_LoginUsuarioInvalido");
			homePage.irALoguearse(datosCP.get(1), datosCP.get(2));
			Assert.assertEquals(homePage.verificarLoginNotOk(), datosCP.get(3));
			homePage.despuesVerificarLoginNotOk();
		}
		@Test
		public void CP005_LoginClaveInvalida() {
			//Hacer Login (si aparece el captcha se cae)
			datosCP = DataDriven.getData("CP005_LoginClaveInvalida");
			homePage.irALoguearse(datosCP.get(1), datosCP.get(2));
			Assert.assertEquals(homePage.verificarLoginNotOk(), datosCP.get(3));
			homePage.despuesVerificarLoginNotOk();
		}
		@Test
		public void CP006_LoginNoOK1() {
			//Hacer Login (si aparece el captcha se cae)
			datosCP = DataDriven.getData("CP006_LoginNoOK1");
			homePage.irALoguearse(datosCP.get(1), datosCP.get(2));
			Assert.assertEquals(homePage.verificarLoginNotOk(), datosCP.get(3));
			homePage.despuesVerificarLoginNotOk();
		}
		
		@Test
		public void CP007_LoginNoOK2() {
			//Hacer Login (si aparece el captcha se cae)
			datosCP = DataDriven.getData("CP007_LoginNoOK2");
			homePage.irALoguearse(datosCP.get(1), datosCP.get(2));
			Assert.assertEquals(homePage.verificarLoginNotOk(), datosCP.get(3));
			homePage.despuesVerificarLoginNotOk();
		}
		
		@Test
		public void CP008_LoginVacio() {
			//Hacer Login (si aparece el captcha se cae)
			datosCP = DataDriven.getData("CP008_LoginVacio");
			homePage.irALoguearse(datosCP.get(1), datosCP.get(2));
			Assert.assertEquals(homePage.verificarLoginNotOk(), datosCP.get(3));
			homePage.despuesVerificarLoginNotOk();
		}
		
		@Test
		public void CP003_RegistrateOk() {
			//El caso llega hasta que se pide introducir un código que llega al teléfono de la socia
			datosCP = DataDriven.getData("CP003_RegistrateOk");
			homePage.irARegistrate();
			Assert.assertEquals(registratePage.verificarRegistro(), datosCP.get(1));
			//registratePage.irARun();
			registratePage.irARun(datosCP.get(2));
			//Assert.assertEquals(homePage.verificarLogin(), datosCP.get(3));
			Assert.assertEquals(registratePage.verificarRegistro2(), datosCP.get(3));
		}
		
		@Test
		public void CP004_RegistrateNotOk() {
			//El caso llega hasta que se pide introducir un código que llega al teléfono de la socia
			//Ok al 7-11-22
			datosCP = DataDriven.getData("CP004_RegistrateNotOk");
			homePage.irARegistrate();
			Assert.assertEquals(registratePage.verificarRegistro(), datosCP.get(1));
			//registratePage.irARun();
			registratePage.irARun(datosCP.get(2));
			//Assert.assertEquals(homePage.verificarLogin(), datosCP.get(3));
		}
		
		@Test
		public void CP005_Encuentranos() throws InterruptedException {
			//Clic en Encuentranos 
			datosCP = DataDriven.getData("CP005_Encuentranos");
			homePage.irAEncuentranos();
			Thread.sleep(3000);
			//driver = oficinaPage.getDriver();
			this.driver.close();
			
			//driver.get(urlSitio);
		//	String getTitle = driver.getTitle();
			//System.out.println(getTitle);
			//se cae en el assert (hay que cambiar de frame quizas)
			//Assert.assertEquals(oficinaPage.verificarEncuentranos(), datosCP.get(1));
			//((JavascriptExecutor)driver).executeScript("window.open()"); 
		     // abre un tab nuevo o se puede colocar el url
			//Thread.sleep(5000);
		}
		
		//INICIO
		@Test
		public void CP004_Inicio() {
			//
			datosCP = DataDriven.getData("CP004_Inicio");
			homePage.irALoguearse(datosCP.get(1), datosCP.get(2));
			Assert.assertEquals(homePage.verificarLogin(), datosCP.get(3));
			
		}
		
		@Test
		public void CP005_IrAPagarMiCredito() throws InterruptedException {
			//
			datosCP = DataDriven.getData("CP002_Encuentranos");
			homePage.irAEncuentranos();
			Thread.sleep(3000);
			//driver = oficinaPage.getDriver();
			this.driver.close();
		}
		
		@Test
		public void CP006_Capacitacion() {
			//El caso llega hasta que se pide introducir un código que llega al teléfono de la socia
			datosCP = DataDriven.getData("CP003_Registrate");
			homePage.irARegistrate();
			//registratePage.irARun();
			registratePage.irARun(datosCP.get(1));
			//Assert.assertEquals(homePage.verificarLogin(), datosCP.get(3));
		}
	
		@Test
		public void CP007_Documentos() {
			//El caso llega hasta que se pide introducir un código que llega al teléfono de la socia
			datosCP = DataDriven.getData("CP003_Registrate");
			homePage.irARegistrate();
			//registratePage.irARun();
			registratePage.irARun(datosCP.get(1));
			//Assert.assertEquals(homePage.verificarLogin(), datosCP.get(3));
		}
		
		@Test
		public void CP008_Beneficios() {
			//El caso llega hasta que se pide introducir un código que llega al teléfono de la socia
			datosCP = DataDriven.getData("CP003_Registrate");
			homePage.irARegistrate();
			//registratePage.irARun();
			registratePage.irARun(datosCP.get(1));
			//Assert.assertEquals(homePage.verificarLogin(), datosCP.get(3));
		}
		
		@Test
		public void CP009_VerPagos() {
			//El caso llega hasta que se pide introducir un código que llega al teléfono de la socia
			datosCP = DataDriven.getData("CP003_Registrate");
			homePage.irARegistrate();
			//registratePage.irARun();
			registratePage.irARun(datosCP.get(1));
			//Assert.assertEquals(homePage.verificarLogin(), datosCP.get(3));
		}
/*
	// Atributos
	private WebDriver driver;
	private HomePage homePage;
	private ContactUs ContactUsPage;
	private SignIn SignInPage;
	private Women WomenPage;
	private String urlSitio;
	private ArrayList<String> datosCP;

	@BeforeTest
	public void preparacion() {
		String rutaDriver = PropertiesDriven.obtenerProperty("rutaDriver");
		//String rutaDriver = System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\chromedriver.exe";
		String browser = PropertiesDriven.obtenerProperty("browser");
		//String browser = "Chrome";
		String propertyDriver = PropertiesDriven.obtenerProperty("propertyDriver");
		//String propertyDriver = "webdriver.chrome.driver";
		homePage = new HomePage(driver);
		homePage.conexionDriver(browser, rutaDriver, propertyDriver);
		SignInPage = new SignIn(homePage.getDriver());
		ContactUsPage = new ContactUs(homePage.getDriver());
		urlSitio = PropertiesDriven.obtenerProperty("url");
		//urlSitio = "http://automationpractice.com/index.php";
		datosCP = new ArrayList<>();

	}
	
	@BeforeMethod
	public void preparacionTests() {
		homePage.cargarURL(urlSitio);
		homePage.maximizarBrowser();
	}

	@AfterMethod
	public void posTests() {
	}

	// NOTA IMPORTANTE:
	// Antes de correr la suite de pruebas por 2da vez, deben editarse los emails en el archivo excel
	// en las celdas resaltadas en rojo y colocar emails nuevos para que los casos corran
	
	@Test
	public void CP001_BusquedaDeProducto() {
		datosCP = DataDriven.getData("CP001_BusquedaDeProducto");
		homePage.buscarProducto(datosCP.get(1)); 
		Assert.assertEquals(homePage.verificarProductoBuscado(), datosCP.get(2));
		//Cp verificado, pasó!
	}

	@Test
	public void CP002_AgregarProductoAlCarro() {
		datosCP = DataDriven.getData("CP002_AgregarProductoAlCarro");
		homePage.buscarProducto(datosCP.get(1)); 
		homePage.agregarAlCarro();
		//homePage.verificarProductoAnadido();
		Assert.assertEquals(homePage.verificarProductoAnadido(), datosCP.get(2));
		homePage.vaciarElCarrito();
		//Cp verificado, pasó!
	}

	@Test
	public void CP003_ValidarMsjDeInformacionPersonal() {
		datosCP = DataDriven.getData("CP003_ValidarMsjDeInformacionPersonal");
		homePage.irASignIn();
		SignInPage.irACreateAnAccount(datosCP.get(1)); 
		//SignInPage.irAValidarMsj();
		Assert.assertEquals(SignInPage.verificarMsj(), datosCP.get(2));
		//Cp verificado, pasó!
	}

	@Test
	public void CP004_SignIn_CrearUnaCuentaConEmailYaRegistrado() {
		//NOTA: no cambiar el email en el archivo excel
		datosCP = DataDriven.getData("CP004_SignIn_CrearUnaCuentaConEmailYaRegistrado");
		homePage.irASignIn();
		SignInPage.irACreateAnAccountMailExisted(datosCP.get(1)); 
		Assert.assertEquals(SignInPage.verificarEmailYaRegistrado(), datosCP.get(2));
		
		//Cp verificado, pasó!
	}
	
	@Test
	public void CP005_SignIn_CrearUnaCuenta() {
		//NOTA: cambiar el email en el archivo excel al correrlo por segunda vez para que sea un email nuevo
		datosCP = DataDriven.getData("CP005_SignIn_CrearUnaCuenta");
		homePage.irASignIn();
		SignInPage.irACreateAnAccount(datosCP.get(1)); 
		SignInPage.irAFillTxtCreateAnAccount(datosCP.get(2), datosCP.get(3), datosCP.get(4), datosCP.get(5), datosCP.get(6), datosCP.get(7), datosCP.get(8), datosCP.get(9), datosCP.get(10), datosCP.get(11), datosCP.get(12), datosCP.get(13), datosCP.get(14), datosCP.get(15), datosCP.get(16), datosCP.get(17), datosCP.get(18));
		Assert.assertEquals(SignInPage.verificarCrearUnaCuenta(), datosCP.get(19));
		SignInPage.desloguearse();
		//Cp verificado, pasó!
	}

	@Test
	public void CP006_SignIn_YaRegistrado() {
		//NOTA: no cambiar el email ni contraseña en el archivo excel
		datosCP = DataDriven.getData("CP006_SignIn_YaRegistrado");
		homePage.irASignIn();
		SignInPage.irAAlreadyRegistered(datosCP.get(1),datosCP.get(2)); // 
		Assert.assertEquals(SignInPage.verificarAlreadyRegistered(), datosCP.get(3));
		SignInPage.desloguearse();
		//Cp verificado, pasó! 
	}

	@Test
	public void CP007_SuscribirseAlNewsletter() {
		//NOTA: cambiar el email en el archivo excel al correrlo por segunda vez para que sea un email nuevo
		datosCP = DataDriven.getData("CP007_SuscribirseAlNewsletter");
		homePage.subscribeToNewsletter(datosCP.get(1)); 
		Assert.assertEquals(homePage.verificarSubscripcionNewsletter(),datosCP.get(2));
		
		//Cp verificado, pasó! 
	}

	@Test
	public void CP008_FlujoCompletoProcederAlCheckout() {
		//NOTA: no cambiar el email ni contraseña en el archivo excel
		datosCP = DataDriven.getData("CP008_FlujoCompletoProcederAlCheckout");
		homePage.buscarProducto(datosCP.get(1)); 
		homePage.agregarAlCarro();
		Assert.assertEquals(homePage.verificarProductoAnadido(), datosCP.get(5));
		homePage.procederAlCheckout1();
		homePage.procederAlCheckout2();
		SignInPage.irAAlreadyRegistered(datosCP.get(2),datosCP.get(3));
		homePage.procederAlCheckout3();
		homePage.aceptarTerminosYCondiciones();
		homePage.procederAlCheckout4();
		homePage.pagarPorTransferencia();
		homePage.confirmarMiOrden();
		Assert.assertEquals(homePage.verificarConfirmarMiOrden(), datosCP.get(4));
	
		//Cp verificado, pasó! 
	}
*/
}
