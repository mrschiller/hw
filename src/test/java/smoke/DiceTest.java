package smoke;

import base.BaseTest;
import base.Helper;
import datadriven.Actions;
import datadriven.DataProvider;
import datadriven.Input;
import datadriven.Verify;
import model.PuzzlersScreenModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class DiceTest extends BaseTest {

    private PuzzlersScreenModel puzzlersScreenModel = new PuzzlersScreenModel();
    private final static String INPUT="input";
    private final static String VERIFY="verify";

    @Test
    public void verifyPlusDiceAppearsAtleastOnceTest() {
        puzzlersScreenModel.lnkDice.click();
        puzzlersScreenModel.btnShuffle.click();
        int iterationCounter = 1;
        while (iterationCounter < 2) {
            currentIterationVerification();
            iterationCounter++;
            sleep(500);
        }
    }

    public void currentIterationVerification() {
        Date iterationStartTimePlus21Seconds = Helper.getCurrentTimePlusXSeconds(21);
        Boolean passMetric = false;
        while (new Date().before(iterationStartTimePlus21Seconds)) {
            sleep(500);
            if (puzzlersScreenModel.getLblPlusSquare().size() > 2) {
                passMetric = true;
            }
        }
        Assert.assertTrue(passMetric);
    }


}