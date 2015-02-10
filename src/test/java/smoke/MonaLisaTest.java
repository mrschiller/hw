package smoke;

import base.BaseTest;
import base.ConfigReader;
import model.PuzzlersScreenModel;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.actions;

public class MonaLisaTest extends BaseTest {

    private PuzzlersScreenModel puzzlersScreenModel = new PuzzlersScreenModel();
    private static String MUSTACHE = ConfigReader.getValueByKey("mustache");

    @Test
    public void verifyMustacheAppearOverMonaLisa() {
        puzzlersScreenModel.lnkMonaLisa.click();
        actions().moveToElement(puzzlersScreenModel.lblMonaLisa).build().perform();
        verifyPictureExists(MUSTACHE);
    }

    public void verifyPictureExists(String picturePath){
        Screen s = new Screen();
        Pattern picture = new Pattern(picturePath);
        try {
            s.find(picture);
        } catch (FindFailed e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
