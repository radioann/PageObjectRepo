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
    private By usernameField = By.xpath("//input[@id='user[login]']");
    private By emailField = By.xpath("//input[@id='user[email]");
    private By passwordField = By.xpath("//input[@id='user[password]']");

    public MainPage() {

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

    public SignUpPage clickSignUpForGitHub() {
        driver.findElement(signUpForGitHubButton).click();
        return new SignUpPage(driver);
    }

    //Methods for filling the input fields on Main  Page

    public MainPage fillUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public MainPage fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public MainPage fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
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
