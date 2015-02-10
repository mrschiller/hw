package base;


import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseTest {

    private static String APP_URL = "app_url";
    private static String CHROME_DRIVER = "chromeDriver";
    private static String BROWSER = "browser";

    @BeforeSuite
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfigReader.getValueByKey(CHROME_DRIVER));
        Configuration.browser=ConfigReader.getValueByKey(BROWSER);
        Configuration.baseUrl=ConfigReader.getValueByKey(APP_URL);

    }

    @BeforeMethod
    public static void startBrowser() {
       open("");
    }

    public void sleep(int millis){
        try{
            Thread.sleep(millis);
        }
        catch (InterruptedException e){

        }
    }
}
