package AufgabeCucumber.stepdefinition;

import AufgabeCucumber.utilities.AufgabeDriver;
import AufgabeCucumber.Page.AufgabePage;
import AufgabeCucumber.utilities.ReusableMethods;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.io.IOException;

public class AufgabeStepDef {

    AufgabePage aufgabePage = new AufgabePage();
    TouchAction touchAction;

    @Given("Open app in android mobile phone")
    public void openAppInAndroidMobilePhone() {
        AufgabeDriver.getAppiumDriver();
    }

    @When("Klicken Plus Button")
    public void klickenPlusButton() {
        aufgabePage.plusButton.click();
    }

    @Then("Screiben {string} in Textfeld")
    public void screibenInTextfeld(String test) {
        aufgabePage.aufgabeSchreibung.sendKeys(test);
    }

    @Then("Klicken Datum button")
    public void klickenDatumButton() {
        aufgabePage.datumButton.click();
    }

    @Then("Wählen datum aus")
    public void wählenDatumAus() {
        aufgabePage.nextButtonInDatum.click();
        aufgabePage.tagInDatum.click();
    }


    @Then("Assert {string} in Datum Header")
    public void assertInDatumHeader(String datum) {
        Assert.assertEquals(aufgabePage.headerDatum.getText(),datum);
        aufgabePage.okButton.click();
    }

    @Then("Klicken Zeit button")
    public void klickenZeitButton() {
        aufgabePage.zeitButton.click();
    }

    @Then("Wählen Zeit aus")
    public void wählenZeitAus() {
        touchAction = new TouchAction(AufgabeDriver.getAppiumDriver());
        touchAction.press(ElementOption.element(aufgabePage.hour)).release().perform();
        touchAction.press(ElementOption.element(aufgabePage.minute)).release().perform();
        aufgabePage.okButton.click();
        //alternative way
        //touchAction.press(ElementOption.element(aufgabePage.hour)).
         //       waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).
         //       moveTo(ElementOption.element(aufgabePage.minute)).perform();

    }

    @Then("Klicken Done Button")
    public void klickenDoneButton() {
        aufgabePage.doneButton.click();
    }

    @Then("Assert Neuer Task {string} wurde erstellt und ist in der Liste sichtbar")
    public void assertNeuerTaskWurdeErstelltUndIstInDerListeSichtbar(String text) {
        Assert.assertEquals(aufgabePage.title.getText(),text);
    }


    @Then("Klicken Cancel Button")
    public void klickenCancelButton() throws InterruptedException {
        aufgabePage.cancelButton.click();
        Thread.sleep(2000);
    }

    @Then("Assert Es wurde kein neuer Task hinzufügt, oben steht noch immer {string}")
    public void assertEsWurdeKeinNeuerTaskHinzufügtObenStehtNochImmer(String toDoText) {
        //System.out.println(aufgabePage.textViewInMainPage.getText());
        Assert.assertTrue(aufgabePage.textViewInMainPage.getText().contains(toDoText));
    }

    @Then("Assert Fehlermeldung {string} erscheint")
    public void assertFehlermeldungErscheint(String fehlerMeldung) {
        Assert.assertEquals(aufgabePage.emptyToast.getText(),fehlerMeldung);
    }

    @Then("Klicken Mülltonnen Icon")
    public void klickenMülltonnenIcon() {
        aufgabePage.deleteButton.click();
    }

    @Then("Assert {string} erscheint")
    public void assertErscheint(String fehlerMeldung) {
        Assert.assertEquals(aufgabePage.deleteToast.getText(),fehlerMeldung);
    }

    @When("Klicken Sonne-Mond Icon")
    public void klickenSonneMondIcon() throws InterruptedException {
        aufgabePage.actionIcon.click();
        Thread.sleep(2000);
    }

    @Then("Assert Background Farbe der Veränderung")
    public void assertBackgroundFarbeDerVeränderung() throws IOException, InterruptedException {

        int redFarbe = ReusableMethods.farbe(aufgabePage.actionBar);

        Assert.assertEquals("Action bar color black",255,redFarbe);
    }

    @And("schließen App")
    public void schließenApp() {
        AufgabeDriver.quitAppiumDriver();
    }

}
