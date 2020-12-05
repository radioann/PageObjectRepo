import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    private WebElement signInButton;
    @FindBy(xpath = "//a[contains(text(),'Sign up')][1]")
    private WebElement signUpButton;
    @FindBy(xpath = "//button[@class='btn-mktg btn-primary-mktg btn-large-mktg f4 btn-block my-3']")
    private WebElement signUpForGitHubButton;
    @FindBy(xpath = "//input[@id='user[login]']")
    private WebElement usernameField;
    @FindBy(xpath = "//input[@id='user[email]")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='user[password]']")
    private WebElement passwordField;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Method returns LogIn page by clicking SignIn button
    public LogInPage clickSignIn() {
        signInButton.click();
        return new LogInPage(driver);
    }
    //Method returns SignUp page by clicking SignUp button
    public SignUpPage clickSignUp(){
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpForGitHub() {
        signUpForGitHubButton.click();
        return new SignUpPage(driver);
    }

    //Methods for filling the input fields on Main  Page

    public MainPage fillUsername(String username){
        usernameField.sendKeys(username);
        return this;
    }

    public MainPage fillEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public MainPage fillPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    //Method Register having created methods inside it

    public SignUpPage register(String username, String email, String password){
        this.fillUsername(username);
        this.fillEmail(email);
        this.fillPassword(password);
        this.clickSignUpForGitHub();
        return new SignUpPage(driver);
    }
}
