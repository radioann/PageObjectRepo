import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By usernameField = By.xpath("//input[@id='user_login']");
    private By emailField = By.xpath("//input[@id='user_email']");
    private By passwordField = By.xpath("//input[@id='user_password']");
    private By emailCheckBox = By.xpath("//input[@id='all_emails']");
    private By signUpButton = By.xpath("//button[normalize-space()='Create account']");
    private By invalidEmailError = By.xpath("//input[@name='user[email]']/parent::dd/following-sibling::dd");
    private By invalidPasswordError = By.xpath("//dd[@id='input-check-2677']");
    private By suggestedUserName = By.xpath("//div[contains(@class,'js-suggested-usernames-container')]");
    private By blankUsernameError = By.xpath("//input[@name='user[login]']/ancestor::dd/following-sibling::dd");

    public SignUpPage fillInUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public SignUpPage fillEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage fillPasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage markCheckbox(){
        if (!driver.findElement(emailCheckBox).isSelected()) {
            driver.findElement(emailCheckBox).click();
        }
        return this;
    }


    public SignUpPage signUpWithInvalidCreds (String username, String email, String password){
        this.fillInUsername(username);
        this.fillEmailField(email);
        this.fillPasswordField(password);
        this.markCheckbox();
        this.driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public String emailErrorText(){
        String error = driver.findElement(invalidEmailError).getText();
        return error;
    }

    public String emptyUserText(){
        String emptyUserError = driver.findElement(blankUsernameError).getText();
        return emptyUserError;
    }



    public String suggestedUserNameText(){
        return driver.findElement(suggestedUserName).getText();
    }

    public String invalidPasswordText(){
        return driver.findElement(invalidPasswordError).getText();
    }




}
