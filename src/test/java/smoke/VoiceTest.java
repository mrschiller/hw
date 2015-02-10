package smoke;

import base.BaseTest;
import model.PuzzlersScreenModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class VoiceTest extends BaseTest {

    private PuzzlersScreenModel puzzlersScreenModel = new PuzzlersScreenModel();
    private static WebDriver driver;
    private static final String VOICE = "Как дела";

    @Test
    public void verifyVoiceOutput() throws FileNotFoundException, IOException {
        puzzlersScreenModel.lnkVoice.click();
        puzzlersScreenModel.txtInput.setValue(", приятель как дела?");
        openNewApplication();
        sleep(3000);
        puzzlersScreenModel.btnSayHello.click();
        sleep(10000);
        verifyText();
    }

    public void openNewApplication() {
        driver = new ChromeDriver();
        driver.get("https://dictation.io/");
        Select language = new Select(driver.findElement(By.id("lang")));
        language.selectByValue("51");
        WebElement btnStart = driver.findElement(By.id("btn"));
        btnStart.click();
    }

    public void verifyText() {
        Assert.assertEquals(driver.findElement(By.id("labnol")).getText(), VOICE);
        driver.quit();
    }
}
