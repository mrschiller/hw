package smoke;

import base.BaseTest;
import datadriven.DataProvider;
import datadriven.Input;
import datadriven.Verify;
import model.PuzzlersScreenModel;
import org.testng.annotations.Test;

import java.util.Map;

public class SpreadsheetTest extends BaseTest {

    private static final String INPUT = "input";
    private static final String ASSERT = "assert";
    private PuzzlersScreenModel puzzlersScreenModel = new PuzzlersScreenModel();
    private DataProvider dataProvider = new DataProvider();

    @Test
    public void checkDataOnSpreadsheetScreen() {
        puzzlersScreenModel.lnkSpreadsheet.click();
        fillSpreadshett(dataProvider.getData());
    }

    public void fillSpreadshett(Map<Integer, String[]> data){
        for (Map.Entry<Integer, String[]> entry : data.entrySet()) {
            if (entry.getValue()[0].equals(INPUT)) {
                new Input(entry.getValue()[1], entry.getValue()[2]).execute();
            }
            else if (entry.getValue()[0].equals(ASSERT)) {
                new Verify(entry.getValue()[1], entry.getValue()[2]).execute();
            }
        }
    }
}
