import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    private By logInField = By.xpath("//input[@id='login_field']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By logInButton = By.xpath("//input[@value='Sign in']");
    private By logoHeader = By.xpath("//div[@class='auth-form-header p-0']");
    private By errorMessage = By.xpath("//div[@class='container-lg px-2']");
    private By createAccountButton = By.xpath("//a[normalize-space()='Create an account']");

    public LogInPage fillLogInField(String login){
        driver.findElement(logInField).sendKeys(login);
        return this;
    }

    public LogInPage fillPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LogInPage clickLogInButton(){
        driver.findElement(logInButton).click();
        return this;
    }

    public LogInPage incorrectLogIn (String login, String password){
        this.fillLogInField(login);
        this.fillPasswordField(password);
        this.clickLogInButton();
        return new LogInPage(driver);//returning new object of LogIn page
    }

    //Method returning String
    public String getHeaderText(){
        return driver.findElement(logoHeader).getText();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

    public SignUpPage clickCreateAccount(){
        driver.findElement(createAccountButton).click();
        return new SignUpPage(driver);
    }



}
