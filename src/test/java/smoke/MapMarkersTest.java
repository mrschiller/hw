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

public class MapMarkersTest extends BaseTest{

    private PuzzlersScreenModel puzzlersScreenModel = new PuzzlersScreenModel();
    private static String MARKER = ConfigReader.getValueByKey("marker");
    private static String LATITUDE="56.9086";
    private static String LONGITUDE="24.0832";
    private static String POP_UP_TEXT="Vienības gatve 109, Zemgales priekšpilsēta, Rīga, LV-1058, Latvia";

    @Test
    public void verifyMustacheAppearOverMonaLisa() {
        puzzlersScreenModel.lnkMapMarkers.click();
        puzzlersScreenModel.txtLatitude.setValue(LATITUDE);
        puzzlersScreenModel.txtLongitude.setValue(LONGITUDE);
        puzzlersScreenModel.btnAddMarker.click();
        clickAtPicture(MARKER);
        Assert.assertEquals(puzzlersScreenModel.lblPopUp.getText(), POP_UP_TEXT);
    }

    public void clickAtPicture(String picturePath){
        Screen s = new Screen();
        Pattern picture = new Pattern(picturePath);
        try {
            s.click(picture);
        } catch (FindFailed e) {
            e.printStackTrace();
        }
    }
}
