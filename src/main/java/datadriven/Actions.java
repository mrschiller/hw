package datadriven;

import model.PuzzlersScreenModel;
import org.apache.commons.lang.StringUtils;

import static base.Helper.stringToInteger;

public abstract class Actions {

    protected PuzzlersScreenModel puzzlersScreenModel;
    protected String cell;
    protected String value;


    public Actions(String cell, String value) {
        this.puzzlersScreenModel = new PuzzlersScreenModel();
        this.cell = cell;
        this.value = value;
    }

    public abstract void execute();

    //Get real value from abstract locator
    public String getStringValueFromFullExpression(String value) {
        String values[] = value.split("(?<=\\*)|(?=\\*)|(?<=\\+)|(?=\\+)|(?<=\\/)|(?=\\/)|(?<=\\-)|(?=\\-)");
        String finalFirstValue = null;
        String finalSecondValue = null;
        Integer finalComonValue = null;

        finalFirstValue = getFinalValue(values[0]);

        // If value does not have mathematical expressions length == 1
        if (values.length > 1) {
            finalSecondValue = getFinalValue(values[2]);
            switch (values[1]) {
                case "*":
                    finalComonValue = stringToInteger(finalFirstValue) * stringToInteger(finalSecondValue);
                    break;
                case "+":
                    finalComonValue = stringToInteger(finalFirstValue) + stringToInteger(finalSecondValue);
                    break;
                case "-":
                    finalComonValue = stringToInteger(finalFirstValue) - stringToInteger(finalSecondValue);
                    break;
                case "/":
                    finalComonValue = stringToInteger(finalFirstValue) / stringToInteger(finalSecondValue);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid mathematical expression: " + values[1]);
            }
            return String.valueOf(finalComonValue);
        }
        return finalFirstValue;
    }


    public int getRowNumberFromCell(String cell) {
        return Integer.parseInt(cell.substring(1));
    }

    public char getColumnNameFromCell(String cell) {
        return cell.charAt(0);
    }

    public String getValueFromCell(String cell) {
        return puzzlersScreenModel.getCell(getRowNumberFromCell(cell), getColumnNameFromCell(cell)).findElementByXPath("../div").getText();
    }

    public String getFinalValue(String valueAsExpression) {
        if (StringUtils.isNumeric(valueAsExpression)) {
            return valueAsExpression;
        } else {
            return getValueFromCell(valueAsExpression);
        }
    }


}
