package datadriven;

public class Input extends Actions {

    public Input(String cell, String value) {
        super(cell, value);
    }

    public void execute() {
        int rowNumberForInput = getRowNumberFromCell(cell);
        char columnNameForInpur = getColumnNameFromCell(cell);

        puzzlersScreenModel.getCell(rowNumberForInput, columnNameForInpur).setValue(getStringValueFromFullExpression(value));
        puzzlersScreenModel.lnkSpreadsheet.click();
    }


}