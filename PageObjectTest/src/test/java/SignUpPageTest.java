import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {

    static WebDriver driver;
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
    public void signUpWithInvalidEmail(){
        SignUpPage signUpPage = mainPage.clickSignUp();
        SignUpPage newSignUpPage = signUpPage.signUpWithInvalidCreds("lkilly", "khakshd", "12345Qwerty");
        String invalidEmailText = newSignUpPage.emailErrorText();
        Assert.assertEquals("Email is invalid or already taken", invalidEmailText);
    }

    @Test
    public void shortPasswordInput(){
        SignUpPage signUpPage = mainPage.clickSignUp();
        SignUpPage newSP = signUpPage.fillPasswordField("2er");
        String shortPassword = newSP.invalidPasswordText();
        Assert.assertEquals("Password is too short (minimum is 8 characters) and is in a list of passwords commonly used on other websites", shortPassword);
    }

    @Test
    public void usernameReservedWord(){
        SignUpPage signUpPage = mainPage.clickSignUp();
        SignUpPage newSP = signUpPage.fillInUsername("username");
        String usernameError = newSP.errorUserNameText();
        Assert.assertEquals("Username 'username' is unavailable.", usernameError);
    }


    @After
    public void tearDown(){
        driver.quit();
    }

}
