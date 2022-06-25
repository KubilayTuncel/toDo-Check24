package AufgabeCucumber.Page;

import AufgabeCucumber.utilities.AufgabeDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.AufgabeDriver;

import java.time.Duration;

public class AufgabePage {

    public AufgabePage(){
        PageFactory.initElements(new AppiumFieldDecorator(AufgabeDriver.getAppiumDriver(), Duration.ofSeconds(30)),this);
    }

    @AndroidFindBy (id = "com.example.yeshasprabhakar.todo:id/fab")
    public MobileElement plusButton;

    @AndroidFindBy (xpath = "//android.widget.EditText[@text='My Task']")
    public MobileElement aufgabeSchreibung;

    @AndroidFindBy (id = "com.example.yeshasprabhakar.todo:id/date")
    public MobileElement datumButton;

    @AndroidFindBy (id = "android:id/next")
    public MobileElement nextButtonInDatum;

    @AndroidFindBy (xpath = "//android.view.View[@text='13']")
    public MobileElement tagInDatum;

    @AndroidFindBy (id = "android:id/date_picker_header_date")
    public MobileElement headerDatum;

    @AndroidFindBy (xpath = "//android.widget.Button[@text='OK']")
    public MobileElement OkButton;

    @AndroidFindBy (id = "com.example.yeshasprabhakar.todo:id/time")
    public MobileElement zeitButton;

    @AndroidFindBy (accessibility = "10")
    public MobileElement hour;

    @AndroidFindBy (accessibility = "30")
    public MobileElement minute;

    @AndroidFindBy (xpath = "//android.widget.Button[@text='DONE']")
    public MobileElement doneButton;

    @AndroidFindBy (id = "com.example.yeshasprabhakar.todo:id/title")
    public MobileElement title;

    @AndroidFindBy (xpath = "//android.widget.Button[@text='CANCEL']")
    public MobileElement cancelButton;

    @AndroidFindBy (id = "com.example.yeshasprabhakar.todo:id/emptyTextView")
    public MobileElement textViewInMainPage;

    @AndroidFindBy (xpath = "//android.widget.Toast[@text='Oops, Cannot set an empty ToDo!!!']")
    public MobileElement emptyToast;

    @AndroidFindBy (id = "com.example.yeshasprabhakar.todo:id/delete")
    public MobileElement deleteButton;

    @AndroidFindBy (xpath = "//android.widget.Toast[@text='Deleted Successfully!']")
    public  MobileElement deleteToast;

    @AndroidFindBy (id = "com.example.yeshasprabhakar.todo:id/themeActionButton")
    public MobileElement actionIcon;

    @AndroidFindBy (id = "com.example.yeshasprabhakar.todo:id/action_bar")
    public  MobileElement actionBar;


}
