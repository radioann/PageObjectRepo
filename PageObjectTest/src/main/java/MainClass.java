import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class MainClass {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/annaradionova/IdeaProjects/PageObjectRepo/PageObjectTest/drivers/chromedriver");


        MainPage mainPage = new MainPage();
        WebDriver driver = new ChromeDriver();

        driver.get("https://github.com/");
        mainPage.register("tes7145", "tes7145@im.com", "Qwerty143!");

    }
}
