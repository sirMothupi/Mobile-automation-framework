package org.greyytechnologies.android_utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class android_page_objects
{
    public AndroidDriver androidDriver;
    public WebDriverWait wait;
    private AppiumAction appiumAction;
    AndroidEnablers androidEnablers = new AndroidEnablers();

    @AndroidFindBy(
            id = "iv_date_picker"
    )
    private AndroidElement datePicker;
    @AndroidFindBy(
            xpath = "//android.widget.Button[@text=\"OK\"]"
    )
    private AndroidElement datePickerOk;
    @AndroidFindBy(
            xpath = "//android.widget.Button[@text=\"CANCEL\"]"
    )
    private AndroidElement datePickerCancel;
    @AndroidFindBy(
            xpath = "//android.widget.Button[@text=\"Create app PIN\"]"
    )
    private AndroidElement createAppPinBtn;
    @AndroidFindBy(
            id = "android:id/next"
    )
    private WebElement clndNextMonth;
    @AndroidFindBy(
            xpath = "//android.view.View[@text='1']"
    )
    private WebElement clndFirstDate;
    @AndroidFindBy(
            id = "esBtnAction"
    )
    private AndroidElement nextBtn;
    @AndroidFindBy(
            id = "app_rooted_continue"
    )
    private AndroidElement initialLoginBtn;
    @AndroidFindBy(
            id = "permission_deny_button"
    )
    private AndroidElement cameraDenyPermission;
    @AndroidFindBy(
            id = "overview_page_fca_layout"
    )
    private AndroidElement ovrwFCALayout;
    @AndroidFindBy(
            id = "esEdtInput"
    )
    private AndroidElement inputFieldTxt;
    @AndroidFindBy(
            xpath = "(//android.widget.EditText)[1]"
    )
    private AndroidElement genericCredOneTxt;
    @AndroidFindBy(
            xpath = "(//android.widget.EditText)[2]"
    )
    private AndroidElement genericCredTwoTxt;
    @AndroidFindBy(
            xpath = "(//android.widget.EditText)[3]"
    )
    private AndroidElement genericCredThreeTxt;

    public android_page_objects(AndroidDriver androidDriver)
    {
        this.androidDriver = androidDriver;
        this.wait = new WebDriverWait(androidDriver, Duration.ofSeconds(200));
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
        this.appiumAction = new AppiumAction();
    }

}
