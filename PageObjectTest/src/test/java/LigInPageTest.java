import org.junit.*;
import org.junit.rules.Verifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class LigInPageTest {

    static WebDriver driver;
    static LogInPage logInPage;
    static MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/annaradionova/IdeaProjects/PageObjectRepo/PageObjectTest/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com");
        mainPage = new MainPage(driver);
    }

    @Test
    public void logIn(){
        LogInPage logInPage = mainPage.clickSignIn();
        LogInPage newLogInPage = logInPage.clickLogInButton();
        String incorrectLogInMessage = newLogInPage.getErrorMessage();
        assertEquals("Incorrect username or password.", incorrectLogInMessage);
    }

    @Test
    public void enterCreds(){
        LogInPage logInPage = mainPage.clickSignIn();
        logInPage.fillLogInField("radionova.a@gmail.com");
        logInPage.fillPasswordField("Oneofakind#1");
        logInPage.clickLogInButton();
        driver.findElement(By.xpath("//summary[@aria-label='View profile and more']//span[@class='dropdown-caret']")).click();
        WebElement loggedUser = driver.findElement(By.xpath("//div[@class='header-nav-current-user css-truncate']/a"));
        String loggedUserString = loggedUser.getText();
        assertEquals("Signed in as radioann", loggedUserString);
    }

    @Test
    public void createAccountFromSignIn(){
        LogInPage logInPage = mainPage.clickSignIn();
        SignUpPage newSignUp = logInPage.clickCreateAccount();
        String invalidCredError = newSignUp.signUpHeader();
        assertEquals("Create your account", invalidCredError);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
