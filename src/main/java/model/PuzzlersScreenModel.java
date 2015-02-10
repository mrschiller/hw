package model;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PuzzlersScreenModel {

    //Navigation Menu
    public SelenideElement lnkMapMarkers=$(By.cssSelector("div > ul > li:nth-child(1) > a"));
    public SelenideElement lnkSpreadsheet=$(By.cssSelector("div > ul > li:nth-child(2) > a"));
    public SelenideElement lnkDice=$(By.cssSelector("div > ul > li:nth-child(3) > a"));
    public SelenideElement lnkFileDrop=$(By.cssSelector("div > ul > li:nth-child(4) > a"));
    public SelenideElement lnkMonaLisa=$(By.cssSelector("div > ul > li:nth-child(5) > a"));
    public SelenideElement lnkVoice=$(By.cssSelector("div > ul > li:nth-child(6) > a"));

    //MapMarkers
    public SelenideElement txtLatitude = $(By.cssSelector("div:nth-child(1) > div > input"));
    public SelenideElement txtLongitude = $(By.cssSelector("div:nth-child(2) > div > input"));
    public SelenideElement btnAddMarker = $(By.cssSelector("button.btn.btn-primary"));
    public SelenideElement lblPopUp = $(By.cssSelector("div.leaflet-popup-content.ng-scope"));

    //SpreadsheetScreen
    public SelenideElement getCell(int rowNumber, char columnName){
        return $(By.xpath("//table/tbody/tr["+(rowNumber+1)+"]/td["+ ((int) columnName-63)+"]/div/input"));
    }

    //DiceScreen
    public SelenideElement btnShuffle=$(By.cssSelector("div > span.knob.ng-binding"));
    public List<SelenideElement> getLblPlusSquare(){
        return $$(By.cssSelector("i.fa.fa-plus-square"));
    }

    //MonaLisa
    public SelenideElement lblMonaLisa=$(By.id("liza"));

    //Voice
    public SelenideElement txtInput = $(By.cssSelector("input"));
    public SelenideElement btnSayHello = $(By.cssSelector("button"));
}
