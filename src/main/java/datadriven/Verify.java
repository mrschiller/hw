package datadriven;

import org.testng.Assert;

public class Verify extends Actions {

    public Verify(String cell, String value) {
        super(cell, value);
    }

    public void execute() {
        int rowNumberForVerification = getRowNumberFromCell(cell);
        char columnNameForVerification = getColumnNameFromCell(cell);
        org.testng.Assert.assertEquals(getValueFromCell(cell), getStringValueFromFullExpression(value));
    }
}
