import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signInButton = By.xpath("//a[contains(text(),'Sign in')]");
    private By signUpButton = By.xpath("//a[contains(text(),'Sign up')][1]");
    private By signUpForGitHubButton = By.xpath("//button[@class='btn-mktg btn-primary-mktg btn-large-mktg f4 btn-block my-3']");
    private By username = By.xpath("//input[@id='user[login]']");
    private By email = By.xpath("//input[@id='user[email]");
    private By password = By.xpath("//input[@id='user[password]']");

    public void clickSignUpForGitHub(){
        driver.findElement(signUpForGitHubButton).click();
    }

    //Method returns LogIn page by clicking SignIn button
    public LogInPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new LogInPage(driver);
    }
    //Method returns SignUp page by clicking SignUp button
    public SignUpPage clickSignUp(){
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }
}
