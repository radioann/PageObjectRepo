import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

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
    @Ignore
    public void signIn(){
        LogInPage logInPage = mainPage.clickSignIn();
        String header = logInPage.getHeaderText();
        Assert.assertEquals("Sign in to GitHub", header);
    }

    @Test
    @Ignore
    public void signUp(){
        //SignUpPage signUpPage = mainPage.clickSignUpForGitHub();
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.fillEmailField("khlgsh");
        String invalidEmail = signUpPage.emailErrorText();
        //Email is invalid or already taken
        Assert.assertEquals("gljglj", invalidEmail);

    }

    @Test
    public void signUpWithEmptyUserName(){
        SignUpPage signUpPage = mainPage.register("", "gkjbklknnkjv@kjbjk.com", "woijhoi778");
        String suggestedError = signUpPage.suggestedUserNameText();
        Assert.assertEquals("Username can't be blank", suggestedError);

    }



    @After
    public void tearDown(){
        driver.quit();
    }
}
